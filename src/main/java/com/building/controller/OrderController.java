package com.building.controller;

import com.building.common.lang.Result;
import com.building.entity.OrderHistory;
import com.building.entity.User;
import com.building.entity.WorkOrder;
import com.building.entity.vo.HistoryVo;
import com.building.entity.vo.OrderVO;
import com.building.service.EmailService;
import com.building.service.OrderHistoryService;
import com.building.service.UserService;
import com.building.service.WorkOrderService;
import com.building.util.Entity2VO;
import com.building.util.PageUtils;
import com.building.util.UploadUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CDSY
 * @since 2020-12-15
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private WorkOrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderHistoryService orderHistoryService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/list")
    public Result getAllOrders(@RequestParam(defaultValue = "1") String currentPage, @RequestParam(defaultValue = "5")String pageSize){
        String count = orderService.getOrderCount().toString();
        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<WorkOrder> list = orderService.searchAllOrder();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
        List<WorkOrder> listVO = Entity2VO.entityList2VOList(list, OrderVO.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

    @GetMapping("/getOrderById")
    public Result detail(String id) {
        WorkOrder order = orderService.searchOrderById(id);
        return Result.success(order);
    }

    @PostMapping("/add")
    public Result add(@Validated @RequestBody WorkOrder order) {
        if(orderService.searchOrderById(order.getWorkId()) != null){
            return Result.fail("该订单已存在");
        }
        if(!order.getDealId().isEmpty()){
            order.setWorkStatus(2);
        }else {
            order.setWorkStatus(1);
        }

        order.setCreatedTime(new Date());
        orderService.saveOrder(order);
        return Result.success("添加成功");
    }

    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody WorkOrder order) {

        orderService.updateOrder(order);

        return Result.success("更新成功");
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody HashMap<String, String> map) {
        orderService.deleteOrder(map.get("id"));
        return Result.success("删除成功");
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public Result uploadImage(MultipartFile file){

        if (!file.isEmpty()) {
            String dbPath = null;
            Map<String,String> map = UploadUtils.upLoadImage(file);
            if (map.get("success") != null){
                dbPath = map.get("success");
                return Result.success(dbPath);
            }else{
                return Result.fail(map.get("failure"));
            }
        } else {
            return null;
        }
    }

    @GetMapping("/sendOrder")
    public Result sendOrder(String orderId, String dealId){
        if(StringUtils.isEmpty(orderId)){
            return Result.fail("未接收到工单");
        }
        if(StringUtils.isEmpty(dealId)){
            return Result.fail("未选择受理人");
        }

        WorkOrder order = orderService.searchOrderById(orderId);
        order.setDealId(dealId);
        order.setWorkStatus(2);
        orderService.updateOrder(order);
        String userId = dealId;

        //向受理人发送邮件提醒
//        List<User> user = userService.search(userId,"","");
//        String emailResult = emailService.acceptOrderMail(user.get(0).getUserName(),user.get(0).getEmail());
//        if(!"OK".equals(emailResult)){
//            Result.fail("邮件发送失败");
//        }
        return Result.success("已派发工单");
    }

    @GetMapping("/reject")
    public Result rejectOrder(String orderId, String dealId,String reason){
        if(StringUtils.isEmpty(orderId)){
            return Result.fail("未接收到工单");
        }
        if(StringUtils.isEmpty(dealId)){
            return Result.fail("未选择受理人");
        }

        List<User> user = userService.search(dealId,"","");

        WorkOrder order = orderService.searchOrderById(orderId);
        order.setWorkId(orderId);
        order.setDealId("");
        order.setWorkStatus(1);
        orderService.updateOrder(order);

        //向受理人发送邮件提醒
//        List<User> user = userService.search(userId,"","");
//        String emailResult = emailService.acceptOrderMail(user.get(0).getUserName(),user.get(0).getEmail());
//        if(!"OK".equals(emailResult)){
//            Result.fail("邮件发送失败");
//        }
        return Result.success(user.get(0).getUserName()+"先生/女士已拒绝接受该工单，请重新派单",reason);
    }

    @GetMapping("/receiveOrder")
    public Result receiveOrder(String orderId, String dealId){
        if(StringUtils.isEmpty(orderId)){
            return Result.fail("未接收到工单");
        }
        if(StringUtils.isEmpty(dealId)){
            return Result.fail("未选择受理人");
        }

        WorkOrder order = orderService.searchOrderById(orderId);
        order.setWorkId(orderId);
        order.setDealId(dealId);
        order.setWorkStatus(3);
        orderService.updateOrder(order);

        return Result.success("维修人员已接单，请耐心等待结果");
    }

    @GetMapping("/getOrderByWhere")
    public Result getOrderByWhere(String param,String keyword,String currentPage,String pageSize) {
        Integer count = 0;
        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));

        List<WorkOrder> list = orderService.searchOrderByWhere(param,keyword);
        for (WorkOrder order:list){
            count++;
        }
        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,String.valueOf(count));
        List<WorkOrder> listVO = Entity2VO.entityList2VOList(list, OrderVO.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

    @GetMapping("/getAllOrderHistory")
    public Result getOrderHistory(String currentPage,String pageSize){
        Integer count = 0;
        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<WorkOrder> list = orderService.searchOrderByWhere("workStatus","4");

        for (WorkOrder order:list){
            count++;
        }
        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,String.valueOf(count));
        List<OrderHistory> listVO = Entity2VO.entityList2VOList(list, OrderVO.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

    @PostMapping("/orderComplete")
    public Result orderComplete(@RequestBody HashMap<String, String> map) {

        String orderId = map.get("orderId");
        String remark = map.get("remark");
        if (StringUtils.isBlank(orderId)) {
            return Result.fail("传入的维修工单ID(orderId)不能为空");
        }

        WorkOrder order = orderService.searchOrderById(orderId);
        //上报完成后，工单状态改变为4
        order.setWorkStatus(4);
        order.setEndTime(new Date());
        //更新数据库
        orderService.updateOrder(order);
        //创建历史工单类
        OrderHistory completeOrder = new OrderHistory();
        //判断备注是否为空，不为空则添加备注
        if (StringUtils.isNoneBlank(remark)) {
            completeOrder.setRemark(remark);
        }
        //给历史工单的每项数据赋值
        completeOrder.setEndTime(new Date());
        completeOrder.setCreater(order.getCreater());
        completeOrder.setCreatedTime(order.getCreatedTime());
        completeOrder.setDealId(order.getDealId());
        completeOrder.setEquipmentId(order.getEquipmentId());
        completeOrder.setProblem(order.getDescription());
        completeOrder.setHistoryId(String.valueOf(new Date().getTime() / 1000));
        completeOrder.setWorkType(order.getWorkType());

        try {
            //保存历史工单到数据库
            orderHistoryService.saveOrder(completeOrder);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        //在之前的工单表中删除
//        orderService.deleteOrder(orderId);

        //邮件方式通知创建者工单完成
//        String emailResult = emailService.completeOrderMail("","");
//        if(!"OK".equals(emailResult)){
//            Result.fail("邮件发送失败");
//        }
        return Result.success(null);
    }

    @GetMapping("/getHistoryByDay")
    public Result getHistoryByDay(@RequestParam(defaultValue = "1") String currentPage, @RequestParam(defaultValue = "5")String pageSize){
        String count = orderHistoryService.getCountByDay().toString();

        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<OrderHistory> list = orderHistoryService.getHistoryByDay();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
        List<OrderHistory> listVO = Entity2VO.entityList2VOList(list, HistoryVo.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

    @GetMapping("/getHistoryByWeek")
    public Result getHistoryByWeek(@RequestParam(defaultValue = "1") String currentPage, @RequestParam(defaultValue = "5")String pageSize){

        String count = orderHistoryService.getCountByWeek().toString();

        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<OrderHistory> list = orderHistoryService.getHistoryByWeek();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
        List<OrderHistory> listVO = Entity2VO.entityList2VOList(list, HistoryVo.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

    @GetMapping("/getHistoryByMonth")
    public Result getHistoryByMonth(@RequestParam(defaultValue = "1") String currentPage, @RequestParam(defaultValue = "5")String pageSize){

        String count = orderHistoryService.getCountByMonth().toString();

        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<OrderHistory> list = orderHistoryService.getHistoryByMonth();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
        List<OrderHistory> listVO = Entity2VO.entityList2VOList(list, HistoryVo.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

    @GetMapping("/getHistoryByYear")
    public Result getHistoryByYear(@RequestParam(defaultValue = "1") String currentPage, @RequestParam(defaultValue = "5")String pageSize){

        String count = orderHistoryService.getCountByYear().toString();

        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<OrderHistory> list = orderHistoryService.getHistoryByYear();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
        List<OrderHistory> listVO = Entity2VO.entityList2VOList(list, HistoryVo.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

    @GetMapping("/getHistoryByLastYear")
    public Result getHistoryByLastYear(@RequestParam(defaultValue = "1") String currentPage, @RequestParam(defaultValue = "5")String pageSize){

        String count = orderHistoryService.getCountByLastYear().toString();

        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<OrderHistory> list = orderHistoryService.getHistoryByLastYear();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
        List<OrderHistory> listVO = Entity2VO.entityList2VOList(list, HistoryVo.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

    @GetMapping("/getHistoryByLastWeek")
    public Result getHistoryByLastWeek(@RequestParam(defaultValue = "1") String currentPage, @RequestParam(defaultValue = "5")String pageSize){

        String count = orderHistoryService.getCountByLastWeek().toString();

        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<OrderHistory> list = orderHistoryService.getHistoryByLastWeek();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
        List<OrderHistory> listVO = Entity2VO.entityList2VOList(list, HistoryVo.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

    @GetMapping("/getHistoryByLastMonth")
    public Result getHistoryByLastMonth(@RequestParam(defaultValue = "1") String currentPage, @RequestParam(defaultValue = "5")String pageSize){

        String count = orderHistoryService.getCountByLastMonth().toString();

        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<OrderHistory> list = orderHistoryService.getHistoryByLastMonth();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
        List<OrderHistory> listVO = Entity2VO.entityList2VOList(list, HistoryVo.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

    @GetMapping("/getHistoryByYearMonth")
    public Result getHistoryByYearMonth(@RequestParam(defaultValue = "1") String currentPage, @RequestParam(defaultValue = "5")String pageSize){

        String count = orderHistoryService.getCountByYearMonth().toString();

        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<OrderHistory> list = orderHistoryService.getHistoryByYearMonth();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
        List<OrderHistory> listVO = Entity2VO.entityList2VOList(list, HistoryVo.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

}
