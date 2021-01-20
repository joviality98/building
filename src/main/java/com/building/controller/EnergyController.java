package com.building.controller;

import com.building.common.lang.Result;
import com.building.entity.Energy;
import com.building.service.EnergyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnergyController {

    @Autowired
    private EnergyService energyService;

    @RequestMapping(value = "/energy/show",method = RequestMethod.GET)
    public Result show(Energy energy){
        PageInfo<Energy> pageInfo = energyService.show(energy);
        return Result.success(pageInfo);
    }

    @RequestMapping(value = "/energy/getName",method = RequestMethod.GET)
    public Result getName(String id){
        String name = energyService.getName(id);
        return Result.success(name);
    }

}
