package com.building.controller;


import com.building.common.lang.Result;
import com.building.entity.Collector;
import com.building.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectorController {

    @Autowired
    private CollectorService collectorService;

    @RequestMapping(value = "/collector/collectorAreaId",method = RequestMethod.GET)
    public Result findByCollectorAreaId(String collectorAreaId){
        List<Collector> list = collectorService.findByCollectorAreaId(collectorAreaId);
        return Result.success(list);
    }

}
