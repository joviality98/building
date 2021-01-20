package com.building.dao;


import com.building.entity.Grade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeMapper {

    public List<Grade> find(String energyId);

    public String findName(String id);

    public List<Grade> show();

}
