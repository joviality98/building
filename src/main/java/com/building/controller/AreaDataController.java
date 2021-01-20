package com.building.controller;


import com.building.common.lang.Result;
import com.building.entity.AreaData;
import com.building.service.AreaDataService;
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
public class AreaDataController {

    @Autowired
    private AreaDataService areaDataService;

    @RequestMapping(value = "/area/getProportion", method = RequestMethod.GET)
    public Result getProportion(String energyId, Integer countType){
        return Result.success(areaDataService.getProportion(energyId, countType));
    }

    @RequestMapping(value = "/area/getToday", method = RequestMethod.GET)
    public Result getToday(String energyId){
        return Result.success(areaDataService.getToday(energyId));
    }

    @RequestMapping(value = "/area/data",method = RequestMethod.GET)
    public Result getValue(HttpServletRequest request, @RequestParam(required = false) Date countTime, @RequestParam(required = false) Integer areaId, @RequestParam(required = false) Integer countType, @RequestParam(required = false) String energyId){
        List<AreaData> list = areaDataService.getValue(areaId, countTime, countType, energyId);
        return Result.success(list);
    }

    @RequestMapping(value = "/area/getDataByEnergyId", method = RequestMethod.GET)
    public  Result getDataByEnergyId(String energyId){
        List<AreaData> list = areaDataService.getDataByEnergyId(energyId);
        return Result.success(list);
    }

    @RequestMapping(value = "/area/getAll",method = RequestMethod.GET)
    public Result getAll(){
        List<AreaData> list = areaDataService.getAll();
        return Result.success(list);
    }

    @RequestMapping(value = "/area/getByType",method = RequestMethod.GET)
    public Result getByType(Integer countType){
        List<AreaData> list = areaDataService.getByType(countType);
        return Result.success(list);
    }

    //获取同比
    @RequestMapping(value = "/area/getByYear",method = RequestMethod.GET)
    public Result getValueByYear(int areaId){
        List<AreaData> list = areaDataService.getValueByYear(areaId);
        return Result.success(list);
    }

    @RequestMapping(value = "/area/getByMonth",method = RequestMethod.GET)
    public Result getValueByMonth(int areaId){
        List<AreaData> list = areaDataService.getValueByMonth(areaId);
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
