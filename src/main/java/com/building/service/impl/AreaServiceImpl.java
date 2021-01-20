package com.building.service.impl;


import com.building.dao.AreaMapper;
import com.building.entity.Area;
import com.building.service.AreaService;
import com.building.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;


    @Override
    public List<Area> findAreaTree() {
        List<Area> list = areaMapper.findAreaTree();
        List<Area> resultList = new ArrayList<>();
        resultList = TreeUtils.getTreeList("0",list);
        return resultList;
    }

}
