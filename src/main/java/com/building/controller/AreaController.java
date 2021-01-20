package com.building.controller;


import com.building.common.lang.Result;
import com.building.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/area/findAreaTree",method = RequestMethod.GET)
    public Result findAreaTree() {
        return Result.success(areaService.findAreaTree());
    }

}
