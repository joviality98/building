package com.building.service.impl;

import com.building.dao.SysLogMapper;
import com.building.entity.SysLog;
import com.building.service.SysLogService;
import com.building.util.Maps;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;
//    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveSysLog(SysLog sysLog) {
        sysLogMapper.saveSysLog(sysLog);
    }

    @Override
    public PageInfo<SysLog> show(SysLog sysLog) {
        if(sysLog != null && sysLog.getPageNum() != null){
            PageHelper.startPage(sysLog.getPageNum(),sysLog.getPageSize());
        }
        List<SysLog> list = sysLogMapper.show(Maps.build().beanToMap(sysLog));
        return new PageInfo<SysLog>(list);
    }
}
