package com.building.dao;

import com.building.entity.Equipment;
import com.building.util.MyMapper;

public interface EquipmentMapper extends MyMapper<Equipment> {
    Integer getTotal();
}