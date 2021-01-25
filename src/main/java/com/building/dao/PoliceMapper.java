package com.building.dao;

import com.building.entity.Police;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface PoliceMapper {

    public List<Police> show(Map<String, Object> paramMap);

    public int editDeal(Police police);

    public int add(Police police);

    public Police alarmNumber();

}
