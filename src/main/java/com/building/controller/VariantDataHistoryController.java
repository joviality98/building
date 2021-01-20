package com.building.controller;


import com.building.common.lang.Result;
import com.building.service.VariantDataHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class VariantDataHistoryController {

    @Autowired
    private VariantDataHistoryService variantDataHistoryService;

    @RequestMapping(value = "/variant/history",method = RequestMethod.GET)
    public Result getValue(HttpServletRequest request, @RequestParam(required = false) int variantId, @RequestParam(required = false) Date collectTime){
        String collectValue = variantDataHistoryService.getValue(variantId, collectTime);
        return Result.success(collectValue);
    }

}
