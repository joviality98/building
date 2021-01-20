package com.building.dao;

import com.building.entity.CollectorArea;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectorAreaMapper {

    //查询采集器区域树
    public List<CollectorArea> findTree();

}
