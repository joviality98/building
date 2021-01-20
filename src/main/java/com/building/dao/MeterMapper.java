package com.building.dao;


import com.building.entity.Meter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterMapper {

    //根据采集器id获取仪表数据
    public List<Meter> findByCollectorId(String collectorId);

    //根据id获取name
    public String getName(String id);

}
