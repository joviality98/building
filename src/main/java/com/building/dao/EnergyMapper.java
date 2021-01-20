package com.building.dao;


import com.building.entity.Energy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EnergyMapper {

    public List<Energy> show(Map<String, Object> paramMap);

    public String getName(String id);

}
