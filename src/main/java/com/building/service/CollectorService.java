package com.building.service;


import com.building.entity.Collector;

import java.util.List;

public interface CollectorService {

    public List<Collector> findByCollectorAreaId(String collectorAreaId);

}
