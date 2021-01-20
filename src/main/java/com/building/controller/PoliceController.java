package com.building.controller;

import com.building.common.lang.Result;
import com.building.entity.Police;
import com.building.log.MyLog;
import com.building.service.PoliceService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class PoliceController {

    @Autowired
    private PoliceService policeService;

    @RequestMapping(value = "/alarm/show",method = RequestMethod.GET)
    public Result show(Police police){
        PageInfo<Police> pageInfo = policeService.show(police);
        return Result.success(pageInfo);
    }

    @MyLog("编辑报警信息")
    @RequestMapping(value = "/alarm/edit",method = RequestMethod.POST)
    public Result editDeal(@RequestBody Police police){
        return Result.success(policeService.editDeal(police));
    }

    @MyLog("添加报警")
    @RequestMapping(value = "/alarm/add",method = RequestMethod.POST)
    public Result add(@RequestBody Police police){
        Object obj = policeService.add(police);
        return Result.success(obj);
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder, WebRequest request) {
        //转换日期格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //注册自定义的编辑器
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
