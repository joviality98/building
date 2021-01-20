package com.building.service;

import com.building.entity.Energy;
import com.github.pagehelper.PageInfo;

public interface EnergyService {

    public PageInfo<Energy> show(Energy energy);

    public String getName(String id);

}
