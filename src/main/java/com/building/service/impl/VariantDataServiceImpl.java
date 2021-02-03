package com.building.service.impl;


import com.building.dao.VariantDataMapper;
import com.building.entity.VariantData;
import com.building.service.VariantDataService;
import com.building.util.Maps;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VariantDataServiceImpl implements VariantDataService {

    @Autowired
    private VariantDataMapper variantDataMapper;

    @Override

    public List<VariantData> findVariantData(int variantId, int countType, Date countTime) {
        return variantDataMapper.findVariantData(variantId, countType, countTime);
    }

    @Override
    public PageInfo<VariantData> selectAll(VariantData variantData) {
        if(variantData != null && variantData.getPageNum() != null){
            PageHelper.startPage(variantData.getPageNum(),variantData.getPageSize());
        }
        List<VariantData> list = variantDataMapper.selectAll(Maps.build().beanToMap(variantData));
        return new PageInfo<VariantData>(list);
    }
}
