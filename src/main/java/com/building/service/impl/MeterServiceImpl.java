package com.building.service.impl;


import com.building.dao.MeterMapper;
import com.building.entity.Meter;
import com.building.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterServiceImpl implements MeterService {

    @Autowired
    private MeterMapper meterMapper;

    @Override
    public List<Meter> findByCollectorId(String collectorId) {
        return meterMapper.findByCollectorId(collectorId);
    }

    @Override
    public String getName(String id) {
        return meterMapper.getName(id);
    }
}
