package com.building.controller;

import com.building.common.lang.Result;
import com.building.entity.VariantData;
import com.building.service.VariantDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class VariantDataController {

    @Autowired
    private VariantDataService variantDataService;

    @RequestMapping(value = "/variant/findVariantData",method = RequestMethod.GET)
    public Result findVariantData(HttpServletRequest request, @RequestParam(required = false) int variantId, @RequestParam(required = false) int countType){
        List<VariantData> list = variantDataService.findVariantData(variantId, countType);
        return Result.success(list);
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder, WebRequest request) {
        //转换日期格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //注册自定义的编辑器
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


}
