package com.building.dao;

import com.building.entity.AreaData;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AreaDataMapper {

    //获取当日，当月，当年的能耗*
    public List<AreaData> getEnergy();

    //获取当日的能耗*
    public List<AreaData> getToday(String energyId);

    //获得用能占比*
    public List<AreaData> getProportion(String energyId, Integer countType);

    //获取能源分类的能耗
    public List<AreaData> getEnergyValue(int countValue, Date countTime);

    //根据areaId、countTime、countType、energyId获取数据
    public List<AreaData> getValue(Integer areaId, Date countTime, Integer countType, String energyId);

    //根据energyId 获取数据
    public List<AreaData> getDataByEnergyId(String energyId);

    //获取所有数据
    public List<AreaData> getAll();

    //通过countType获取数据*
    public List<AreaData> getByType(Integer countType);

    //获取每年的countValue总量和同比*
    public List<AreaData> getValueByYear(int areaId);

    //获取每月的总量和同比*
    public List<AreaData> getValueByMonth(int areaId);

    //获取月环比
    public List<AreaData> getHbByMonth(int areaId);
    //获取天环比
    public List<AreaData> getHbByDay(int areaId);
}
