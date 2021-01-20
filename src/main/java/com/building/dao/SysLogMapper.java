package com.building.dao;


import com.building.entity.SysLog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysLogMapper {

    void saveSysLog(SysLog sysLog);
    public List<SysLog> show(Map<String, Object> paramMap);

}
