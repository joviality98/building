package com.building.controller;


import com.building.common.lang.Result;
import com.building.entity.Variant;
import com.building.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class VariantController {

    @Autowired
    private VariantService variantService;

    @RequestMapping(value = "/variant/find",method = RequestMethod.GET)
    public Result find(String collectorId, String meterId) {
        List<Variant> list = variantService.find(collectorId, meterId);
        return Result.success(list);
    }

    @RequestMapping(value = "/variant/findById",method = RequestMethod.GET)
    public Result findById(HttpServletRequest request, @RequestParam(required = false) Integer id) {
        return Result.success(variantService.findById(id));
    }

}
