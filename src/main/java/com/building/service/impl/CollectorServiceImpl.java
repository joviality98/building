package com.building.service.impl;

import com.building.dao.CollectorMapper;
import com.building.entity.Collector;
import com.building.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectorServiceImpl implements CollectorService {

    @Autowired
    private CollectorMapper collectorMapper;

    @Override
    public List<Collector> findByCollectorAreaId(String collectorAreaId) {
        return collectorMapper.findByCollectorAreaId((collectorAreaId));
    }
}
