package com.building.controller;

import com.building.common.lang.Result;
import com.building.entity.User;
import com.building.entity.WorkOrder;
import com.building.entity.vo.OrderVO;
import com.building.entity.vo.TotalVo;
import com.building.log.MyLog;
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

import java.text.SimpleDateFormat;
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

    @MyLog("根据ID搜索工单")
    @GetMapping("/getOrderById")
    public Result detail(String id) {
        WorkOrder order = orderService.searchOrderById(id);
        return Result.success(order);
    }

    @MyLog("添加工单")
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
        return Result.success(null);
    }

    @MyLog("编辑工单")
    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody WorkOrder order) {

        orderService.updateOrder(order);

        return Result.success(null);
    }

    @MyLog("删除工单")
    @PostMapping("/delete")
    public Result delete(@RequestBody HashMap<String, String> map) {
        orderService.deleteOrder(map.get("id"));
        return Result.success(null);
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

    @GetMapping("/calcOrder")
    public Result calcOrder(){
        return Result.success(orderService.getCalcOrder());
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
        return Result.success("已派发工单",null);
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

        return Result.success("维修人员已接单，请耐心等待结果",null);
    }

    @GetMapping("/getOrderByWhere")
    public Result getOrderByWhere(String param,String keyword,@RequestParam(defaultValue = "0") Long start,@RequestParam(defaultValue = "0")Long end,String currentPage,String pageSize) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<WorkOrder> list = null;

        Integer count = 0;

        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        if(start == 0){
            list = orderService.searchOrderByWhere(param,keyword);
            count = orderService.countByWhere(param,keyword);
        }else {
            list = orderService.searchOrderByWhere(param,keyword,simpleDateFormat.format(start),simpleDateFormat.format(end));
            count = orderService.countByWhere(param,keyword,simpleDateFormat.format(start),simpleDateFormat.format(end));
        }

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,String.valueOf(count));
        List<WorkOrder> listVO = Entity2VO.entityList2VOList(list, OrderVO.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
//        return null;
    }


    @GetMapping("/getOrderByUserAndStatus")
    public Result getOrderByUserAndStatus(String userId,String status,String currentPage,String pageSize){
        String count = orderService.countByUserAndStatus(userId,status).toString();

        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<WorkOrder> list = orderService.searchOrderByUserAndStatus(userId,status);

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
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
        List<WorkOrder> listVO = Entity2VO.entityList2VOList(list, OrderVO.class);

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
//        //创建历史工单类
//        OrderHistory completeOrder = new OrderHistory();
//        //判断备注是否为空，不为空则添加备注
//        if (StringUtils.isNoneBlank(remark)) {
//            completeOrder.setRemark(remark);
//        }
//        //给历史工单的每项数据赋值
//        completeOrder.setEndTime(new Date());
//        completeOrder.setCreater(order.getCreater());
//        completeOrder.setCreatedTime(order.getCreatedTime());
//        completeOrder.setDealId(order.getDealId());
//        completeOrder.setEquipmentId(order.getEquipmentId());
//        completeOrder.setProblem(order.getDescription());
//        completeOrder.setHistoryId(String.valueOf(new Date().getTime() / 1000));
//        completeOrder.setWorkType(order.getWorkType());

//        try {
//            //保存历史工单到数据库
//            orderHistoryService.saveOrder(completeOrder);
//        } catch (Exception e) {
//            return Result.fail(e.getMessage());
//        }
        //在之前的工单表中删除
//        orderService.deleteOrder(orderId);

        //邮件方式通知创建者工单完成
//        String emailResult = emailService.completeOrderMail("","");
//        if(!"OK".equals(emailResult)){
//            Result.fail("邮件发送失败");
//        }
        return Result.success(null);
    }

    @GetMapping("/reportByDate")
    public Result reportByDate(String year,String month){
        List<TotalVo> list = null;
        System.out.println("传入的月份为："+month);
        if(month == null){
            list = orderService.getTotal(year);
        }else {
            if(month.length()<2){
                month = '0'+month;
            }
            list = orderService.getTotal(year,month);
        }
        return Result.success(list);
    }
    @GetMapping("/reportByUser")
    public Result reportByUser(String year,String month,String userId){
        List<TotalVo> list = null;
        System.out.println("year="+year+"    month="+month+"    userid="+userId);
//        if(year == null){
//            list = orderService.getTotalbyUser(userId);
//        }else
        if(month == null){
            list = orderService.getTotalbyUser(year,userId);
        }else {
            if(month.length()<2){
                month = '0'+month;
            }
            list = orderService.getTotalbyUser(year,month,userId);
        }
        return Result.success(list);
    }
    @GetMapping("/reportByWeek")
    public Result reportByWeek(String date){
        List<TotalVo> list = null;
        list = orderService.getTotalByWeek(date);
        return Result.success(list);
    }

}
