package com.building.controller;


import com.building.common.lang.Result;
import com.building.entity.Equipment;
import com.building.entity.OrderEquipment;
import com.building.service.EquipmentService;
import com.building.service.OrderEquipmentService;
import com.building.util.Entity2VO;
import com.building.util.PageUtils;
import com.github.pagehelper.PageHelper;
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

//    @PostMapping("/equip/add")
//    public Result add(@Validated @RequestBody Equipment equipment) {
//        equipmentService.save(equipment);
//        return Result.success("success");
//    }
//
//    @PostMapping("/equip/edit")
//    public Result edit(@Validated @RequestBody Equipment equipment) {
//
//        equipmentService.saveOrUpdate(equipment);
//        return Result.success(null);
//    }
//
//    @PostMapping("/equip/{id}")
//    public Result delete(@PathVariable(name = "id") String id) {
//        equipmentService.removeById(id);
//        return Result.success(null);
//    }
}
