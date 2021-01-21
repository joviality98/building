package com.building.service.impl;


import com.building.dao.VariantDataHistoryMapper;
import com.building.service.VariantDataHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VariantDataHistoryServiceImpl implements VariantDataHistoryService {

    @Autowired
    private VariantDataHistoryMapper variantDataHistoryMapper;

    @Override
    public String getValue(Integer variantId, Date collectTime) {
        return variantDataHistoryMapper.getValue(variantId, collectTime);
    }
}
