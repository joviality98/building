package com.building.controller;

import com.building.common.lang.Result;
import com.building.entity.SysLog;
import com.building.service.SysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping(value = "/log/data",method = RequestMethod.GET)
    public Result show(SysLog sysLog) {
        PageInfo<SysLog> pageInfo = sysLogService.show(sysLog);
        return Result.success(pageInfo);
    }

}
