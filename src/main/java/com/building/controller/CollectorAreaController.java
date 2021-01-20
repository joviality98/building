package com.building.controller;


import com.building.common.lang.Result;
import com.building.entity.CollectorArea;
import com.building.service.CollectorAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectorAreaController {

    @Autowired
    private CollectorAreaService collectorAreaService;

    @RequestMapping(value = "/collector/findTree",method = RequestMethod.GET)
    public Result findTree(){
        List<CollectorArea> list = collectorAreaService.findTree();
        return Result.success(list);
    }

}
