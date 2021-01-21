package com.building.dao;


import com.building.entity.VariantData;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> bbea5954caac95170547b5904d7a19d856c5757a
import java.util.List;

@Repository
public interface VariantDataMapper {
<<<<<<< HEAD
    public List<VariantData> findVariantData(int variantId, int countType, Date countTime);
=======
    public List<VariantData> findVariantData(int variantId, int countType);
>>>>>>> bbea5954caac95170547b5904d7a19d856c5757a

}
