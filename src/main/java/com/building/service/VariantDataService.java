package com.building.service;


import com.building.entity.VariantData;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

public interface VariantDataService {

    public List<VariantData> findVariantData(int variantId, int countType, Date countTime);

    PageInfo<VariantData> selectAll(VariantData variantData);
}
