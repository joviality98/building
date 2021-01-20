package com.building.service;

import com.building.entity.Api;
import com.building.entity.vo.ApiVo;

import java.util.List;

public interface ApiService {

    List<Api> getApiUrlByUserName(String username);

    List<ApiVo> getAllApi();

}
