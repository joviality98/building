package com.building.dao;

import com.building.entity.Group;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMapper {

    public Group To(String groupName, String meterId);

}
