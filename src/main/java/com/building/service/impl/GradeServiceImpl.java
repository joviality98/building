package com.building.service.impl;


import com.building.dao.GradeMapper;
import com.building.entity.Grade;
import com.building.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<Grade> find(String energyId) {
        return gradeMapper.find(energyId);
    }

    @Override
    public String findName(String id) {
        return gradeMapper.findName(id);
    }

    @Override
    public List<Grade> show() {
        return gradeMapper.show();
    }
}
