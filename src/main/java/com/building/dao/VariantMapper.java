package com.building.dao;


import com.building.entity.Variant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariantMapper {

    //根据采集器id和仪表id获取变量数据
    public List<Variant> find(String collectorId, String meterId);

    public List<Variant> findById(Integer id);

}
