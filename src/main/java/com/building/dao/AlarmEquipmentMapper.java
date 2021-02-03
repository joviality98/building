package com.building.dao;

import com.building.entity.AlarmEquipment;
import com.building.util.MyMapper;

public interface AlarmEquipmentMapper extends MyMapper<AlarmEquipment> {
    Integer getTotal();
}