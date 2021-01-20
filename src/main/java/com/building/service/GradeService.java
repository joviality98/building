package com.building.service;

import com.building.entity.Grade;

import java.util.List;

public interface GradeService {

    public List<Grade> find(String energyId);

    public String findName(String id);

    public List<Grade> show();

}
