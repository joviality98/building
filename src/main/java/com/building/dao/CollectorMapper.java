package com.building.dao;


import com.building.entity.Collector;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectorMapper {

    //根据采集器区域id查找信息
    public List<Collector> findByCollectorAreaId(String collectorAreaId);

}
