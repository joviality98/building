package com.building.dao;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface VariantDataHistoryMapper {

    public String getValue(Integer variantId, Date collectTime);

}
