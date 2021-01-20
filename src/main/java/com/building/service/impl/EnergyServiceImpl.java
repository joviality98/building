package com.building.service.impl;

import com.building.dao.EnergyMapper;
import com.building.entity.Energy;
import com.building.service.EnergyService;
import com.building.util.Maps;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyServiceImpl implements EnergyService {

    @Autowired
    private EnergyMapper energyMapper;

    @Override
    public PageInfo<Energy> show(Energy energy) {
        if(energy != null && energy.getPageNum() != null){
            PageHelper.startPage(energy.getPageNum(),energy.getPageSize());
        }
        List<Energy> list = energyMapper.show(Maps.build().beanToMap(energy));
        return new PageInfo<Energy>(list);
    }

    @Override
    public String getName(String id) {
        return energyMapper.getName(id);
    }
}
