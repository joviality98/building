package com.building.service;

import com.building.entity.Variant;

import java.util.List;

public interface VariantService {

    public List<Variant> find(String collectorId, String meterId);

    public List<Variant> findById(Integer id);

}
