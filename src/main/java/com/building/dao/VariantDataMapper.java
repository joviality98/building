package com.building.dao;


import com.building.entity.VariantData;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VariantDataMapper {
    public List<VariantData> findVariantData(int variantId, int countType, Date countTime);

}
