package com.building.service;

import com.building.entity.SysLog;
import com.github.pagehelper.PageInfo;


public interface SysLogService {

    void saveSysLog(SysLog sysLog);
    public PageInfo<SysLog> show(SysLog sysLog);

}
