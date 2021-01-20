package com.building.dao;


import com.building.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {

    public List<Area> findAreaTree();

}
