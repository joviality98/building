package com.building.service.impl;

import com.building.dao.PoliceMapper;
import com.building.entity.Police;
import com.building.service.PoliceService;
import com.building.util.Maps;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliceServiceImpl implements PoliceService {

    @Autowired
    private PoliceMapper policeMapper;

    @Override
    public PageInfo<Police> show(Police police) {
        if(police != null && police.getPageNum() != null){
            PageHelper.startPage(police.getPageNum(),police.getPageSize());
        }
        List<Police> list = policeMapper.show(Maps.build().beanToMap(police));
        return new PageInfo<Police>(list);
    }

    @Override
    public int editDeal(Police police) {
        return policeMapper.editDeal(police);
    }

    @Override
    public int add(Police police) {

        return policeMapper.add(police);
    }
}
