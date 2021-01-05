package com.building.dao;

import com.building.entity.WorkOrder;
import com.building.util.MyMapper;

public interface WorkOrderMapper extends MyMapper<WorkOrder> {

    public Integer getOrderCount();

}