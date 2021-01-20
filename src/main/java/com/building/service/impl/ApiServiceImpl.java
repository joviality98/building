package com.building.service.impl;

import com.building.dao.ApiMapper;
import com.building.entity.Api;
import com.building.entity.vo.ApiVo;
import com.building.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiMapper mapper;


    @Override
    public List<Api> getApiUrlByUserName(String username) {
        System.out.println("user api="+mapper.getApiByUsername(username));
        return mapper.getApiByUsername(username);
    }

    @Override
    public List<ApiVo> getAllApi() {
        return mapper.getAllApi();
    }
}

