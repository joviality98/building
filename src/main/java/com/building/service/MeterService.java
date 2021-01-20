package com.building.service;


import com.building.entity.Meter;

import java.util.List;

public interface MeterService {

    public List<Meter> findByCollectorId(String collectorId);

    public String getName(String id);

}
