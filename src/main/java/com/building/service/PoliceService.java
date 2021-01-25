package com.building.service;

import com.building.entity.Police;
import com.github.pagehelper.PageInfo;


public interface PoliceService {
    public PageInfo<Police> show(Police police);

    public int editDeal(Police police);

    public int add(Police police);

    public Police alarmNumber();
}
