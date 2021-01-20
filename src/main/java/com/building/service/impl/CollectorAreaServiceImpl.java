package com.building.service.impl;


import com.building.dao.CollectorAreaMapper;
import com.building.entity.CollectorArea;
import com.building.service.CollectorAreaService;
import com.building.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectorAreaServiceImpl implements CollectorAreaService {

    @Autowired
    private CollectorAreaMapper collectorAreaMapper;

    @Override
    public List<CollectorArea> findTree() {
        List<CollectorArea> list = collectorAreaMapper.findTree();
        List<CollectorArea> resultList = new ArrayList<>();
        resultList = TreeUtils.getTreeList("root",list);
        return resultList;
    }
}
