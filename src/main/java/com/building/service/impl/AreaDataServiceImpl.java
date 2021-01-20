package com.building.service.impl;


import com.building.dao.AreaDataMapper;
import com.building.entity.AreaData;
import com.building.service.AreaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AreaDataServiceImpl implements AreaDataService {

    @Autowired
    private AreaDataMapper areaDataMapper;


    @Override
    public List<AreaData> getToday(String energyId) {
        return areaDataMapper.getToday(energyId);
    }

    @Override
    public List<AreaData> getProportion(String energyId, Integer countType) {
        return areaDataMapper.getProportion(energyId, countType);
    }


    @Override
    public List<AreaData> getValue(Integer areaId, Date countTime, Integer countType, String energyId) {
        List<AreaData> list = areaDataMapper.getValue(areaId, countTime, countType, energyId);
        return list;
    }

    @Override
    public List<AreaData> getDataByEnergyId(String energyId){
        List<AreaData> list = areaDataMapper.getDataByEnergyId(energyId);
        return list;
    }

    @Override
    public List<AreaData> getAll(){
        List<AreaData> list = areaDataMapper.getAll();
        return list;
    }

    @Override
    public List<AreaData> getByType(Integer countType) {
        return areaDataMapper.getByType(countType);
    }

    @Override
    public List<AreaData> getValueByYear(int areaId) {
        return areaDataMapper.getValueByYear(areaId);
    }

    @Override
    public List<AreaData> getValueByMonth(int areaId) {
        return areaDataMapper.getValueByMonth(areaId);
    }

}
