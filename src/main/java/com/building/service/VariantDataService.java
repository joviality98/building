package com.building.service;


import com.building.entity.VariantData;

import java.util.List;

public interface VariantDataService {

    public List<VariantData> findVariantData(int variantId, int countType);

}
