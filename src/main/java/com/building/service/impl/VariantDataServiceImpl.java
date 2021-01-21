package com.building.service.impl;


import com.building.dao.VariantDataMapper;
import com.building.entity.VariantData;
import com.building.service.VariantDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> bbea5954caac95170547b5904d7a19d856c5757a
import java.util.List;

@Service
public class VariantDataServiceImpl implements VariantDataService {

    @Autowired
    private VariantDataMapper variantDataMapper;

    @Override
<<<<<<< HEAD
    public List<VariantData> findVariantData(int variantId, int countType, Date countTime) {
        return variantDataMapper.findVariantData(variantId, countType, countTime);
=======
    public List<VariantData> findVariantData(int variantId, int countType) {
        return variantDataMapper.findVariantData(variantId, countType);
>>>>>>> bbea5954caac95170547b5904d7a19d856c5757a
    }
}
