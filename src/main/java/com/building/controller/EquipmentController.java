package com.building.controller;


import com.alibaba.fastjson.JSON;
import com.building.common.lang.Result;
import com.building.entity.AlarmEquipment;
import com.building.entity.AlarmLog;
import com.building.entity.Equipment;
import com.building.entity.OrderEquipment;
import com.building.service.AlarmEquipmentService;
import com.building.service.EquipmentService;
import com.building.service.OrderEquipmentService;
import com.building.util.Entity2VO;
import com.building.util.PageUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @since 2020-12-03
 */
@RestController
@RequestMapping("/equip")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    OrderEquipmentService orderEquipmentService;

    @Autowired
    AlarmEquipmentService alarmEquipmentService;

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") String currentPage, String pageSize) {
        String count = equipmentService.getEquipmentCount().toString();
        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<Equipment> list = equipmentService.searchAllEquipment();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
        List<Equipment> listVO = Entity2VO.entityList2VOList(list, Equipment.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return Result.success(map);
    }

    @GetMapping("/count")
    public Result count(){
        return Result.success(equipmentService.getEquipmentCount());
    }

    @GetMapping("/getEquipById")
    public Result detail(String id) {
        Equipment equipment = equipmentService.searchEquipmentById(id);
        return Result.success(equipment);
    }
    @PostMapping("/add")
    public Result add(@Validated @RequestBody Equipment equipment) {
        equipmentService.saveEquipment(equipment);
        return Result.success("success");
    }

    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody Equipment equipment) {
        System.out.println(equipment.getCreatedTime());
        equipmentService.updateEquipment(equipment);
        return Result.success("success");
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody HashMap<String, String> map) {
        if(map.get("id") == null){
            return Result.fail("未获取到id");
        }
        equipmentService.deleteEquipment(map.get("id"));
        return Result.success("success");
    }

    @PostMapping("/searchEquip")
    public Result search( @RequestBody HashMap<String,Object> hashMap){

        Map<String,Object> obj = (Map<String, Object>) hashMap.get("equipment");
        Equipment e = JSON.parseObject(JSON.toJSONString(obj),Equipment.class);

//        boolean checkObj =UploadUtils.objCheckIsNull(e);
//        if(checkObj){
//            return Result.fail("选择的条件为空");
//        }

        Integer currentPage =(Integer) hashMap.get("currentPage");
        Integer pageSize =(Integer) hashMap.get("pageSize");

        String count = equipmentService.getSearchCount(e).toString();

        PageHelper.startPage(currentPage,pageSize);
        List<Equipment> list = equipmentService.searchEquipmentByWhere(e);

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage.toString(),count);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", list);
        return Result.success(map);
    }

//    ---------------------------------------------------------

    /**
     * 工单设备图片相关
     * @param orderId
     * @param equipId
     * @return
     */
    @GetMapping("/EquipImg")
    public Result getEquipImg(String orderId,String equipId){
        return Result.success(orderEquipmentService.searchAll(orderId,equipId));
    }

    @PostMapping("/AddEquipImg")
    public Result addEquipImg(@Validated @RequestBody OrderEquipment orderEquipment){
        System.out.println("进入添加图片方法");
        System.out.println(orderEquipment.getEquipId() +"  "+orderEquipment.getOrderId()+"  "+ orderEquipment.getImg());
        orderEquipmentService.saveEquipImg(orderEquipment);
        return Result.success("success");
    }

    @PostMapping("/updateEquipImg")
    public Result updateEquipImg(@Validated @RequestBody OrderEquipment orderEquipment){
        orderEquipmentService.updateEquipImg(orderEquipment);
        return Result.success("success");
    }

    @PostMapping("/deleteEquipImg")
    public Result deleteEquipImg(@Validated @RequestBody OrderEquipment orderEquipment){
        orderEquipmentService.deleteEquipImg(orderEquipment);
        return Result.success("success");
    }

//    ---------------------------------------------
    /**
     * 报警设备相关
     */
    @GetMapping("/alarmList")
    public Result alarmList(@RequestParam(defaultValue = "1") String currentPage, String pageSize) {
        String count = alarmEquipmentService.alarmEquipTotal().toString();
        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<AlarmEquipment> list = alarmEquipmentService.searchAll();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
//        List<AlarmLog> listVO = Entity2VO.entityList2VOList(list, AlarmLog.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", list);
        return Result.success(map);
    }

    @PostMapping("/setAlarmEquip")
    public Result setAlarmEquip(@RequestBody AlarmEquipment alarmEquipment){

        System.out.println("id="+alarmEquipment.getId()+"  alarmid="+alarmEquipment.getAlarmId()+"   equipid="+alarmEquipment.getEquipmentId());
        if(StringUtils.isBlank(alarmEquipment.getEquipmentId())){
            return Result.fail("传入的设备id为空");
        }
        alarmEquipmentService.setAlarmEquipment(alarmEquipment);
        return Result.success("success");
    }

    @PostMapping("/editAlarm")
    public Result updateAlarm(@RequestBody AlarmLog alarmLog){
        if(alarmLog == null){
            return Result.fail("传入的对象为空");
        }
        alarmEquipmentService.editAlarm(alarmLog);
        return Result.success("success");
    }

    @GetMapping("/alarmLogList")
    public Result alarmLogList(@RequestParam(defaultValue = "1") String currentPage, String pageSize) {
        String count = alarmEquipmentService.alarmTotal().toString();
        PageHelper.startPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        List<AlarmLog> list = alarmEquipmentService.alarmList();

        Map<String, Object> pageMap = PageUtils.pageHandler(currentPage,count);
//        List<AlarmLog> listVO = Entity2VO.entityList2VOList(list, AlarmLog.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", list);
        return Result.success(map);
    }

    @GetMapping("/searchAlarm")
    public Result searchAlarm(@RequestBody AlarmLog alarmLog){
        if(alarmLog == null){
            return Result.fail("传入的对象为空");
        }
        alarmEquipmentService.searchAlarm(alarmLog);
        return Result.success("success");
    }

}
