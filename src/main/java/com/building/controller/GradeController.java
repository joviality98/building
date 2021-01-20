package com.building.controller;

import com.building.common.lang.Result;
import com.building.entity.Grade;
import com.building.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping(value = "/grade/find",method = RequestMethod.GET)
    public Result find(String energyId){
        List<Grade> list = gradeService.find(energyId);
        return Result.success(list);
    }

    @RequestMapping(value = "/grade/findName",method = RequestMethod.GET)
    public Result findName(String id){
        return Result.success(gradeService.findName(id));
    }

    @RequestMapping(value = "/grade/show",method = RequestMethod.GET)
    public Result show(){
        List<Grade> list = gradeService.show();
        return Result.success(list);
    }

}
