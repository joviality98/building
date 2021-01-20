package com.building.dao;

import com.building.entity.Api;
import com.building.entity.vo.ApiVo;
import com.building.util.MyMapper;

import java.util.List;

public interface ApiMapper extends MyMapper<Api> {

    List<Api> getApiByUsername(String username);

    List<ApiVo> getAllApi();
}