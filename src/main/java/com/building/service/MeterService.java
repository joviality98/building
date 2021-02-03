package com.building.service;


import com.building.entity.Meter;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MeterService {

    public List<Meter> findByCollectorId(String collectorId);

    public String getName(String id);

    public PageInfo<Meter> getAll(Meter meter);

}
