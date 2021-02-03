package com.building.dao;

import com.building.entity.AlarmLog;
import com.building.util.MyMapper;

public interface AlarmLogMapper extends MyMapper<AlarmLog> {
    Integer getTotal();
}