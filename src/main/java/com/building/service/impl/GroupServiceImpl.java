package com.building.service.impl;

import com.building.dao.GroupMapper;
import com.building.entity.Group;
import com.building.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public Group To(String groupName, String meterId) {
        return groupMapper.To(groupName,meterId);
    }
}
