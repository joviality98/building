package com.building.controller;

import com.building.common.lang.Result;
import com.building.entity.Meter;
import com.building.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MeterController {

    @Autowired
    private MeterService meterService;

    @RequestMapping(value = "/meter/findByCollectorId",method = RequestMethod.GET)
    public Result findByCollectorId(String collectorId){
        List<Meter> list = meterService.findByCollectorId(collectorId);
        return Result.success(list);
    }

    @RequestMapping(value = "/meter/getName",method = RequestMethod.GET)
    public Result getName(String id){
        String name = meterService.getName(id);
        return Result.success(name);
    }

}
