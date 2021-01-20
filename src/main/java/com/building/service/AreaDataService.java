package com.building.service;

import com.building.entity.AreaData;

import java.util.Date;
import java.util.List;

public interface AreaDataService {

    public List<AreaData> getToday(String energyId);

    public List<AreaData> getProportion(String energyId, Integer countType);

    public List<AreaData> getValue(Integer areaId, Date countTime, Integer countType,  String energyId);

    public List<AreaData> getDataByEnergyId(String energyId);

    public List<AreaData> getAll();

    public List<AreaData> getByType(Integer countType);

    public List<AreaData> getValueByYear(int areaId);

    public List<AreaData> getValueByMonth(int areaId);
}
