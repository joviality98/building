package com.building.service.impl;


import com.building.dao.VariantDataMapper;
import com.building.entity.VariantData;
import com.building.service.VariantDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariantDataServiceImpl implements VariantDataService {

    @Autowired
    private VariantDataMapper variantDataMapper;

    @Override
    public List<VariantData> findVariantData(int variantId, int countType) {
        return variantDataMapper.findVariantData(variantId, countType);
    }
}
