package com.building.service.impl;


import com.building.dao.VariantMapper;
import com.building.entity.Variant;
import com.building.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariantServiceImpl implements VariantService {

    @Autowired
    private VariantMapper variantMapper;

    @Override
    public List<Variant> find(String collectorId, String meterId) {
        return variantMapper.find(collectorId, meterId);
    }

    @Override
    public List<Variant> findById(Integer id) {
        return variantMapper.findById(id);
    }
}
