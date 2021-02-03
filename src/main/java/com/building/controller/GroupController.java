package com.building.controller;

import com.building.common.lang.Result;
import com.building.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/meter/group",method = RequestMethod.POST)
    public Result To(String groupName, String meterId) {
        System.out.println(groupName);
        System.out.println(meterId);
        return Result.success(groupService.To(groupName,meterId));
    }

}
