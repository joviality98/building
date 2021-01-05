package com.building.service.impl;


import com.building.dao.UserMapper;
import com.building.entity.User;
import com.building.service.UserService;
import com.building.util.Maps;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean verify(String userName, String password) {
        return userMapper.verify(userName,password)>0;
    }

    @Override
    public PageInfo<User> show(User user) {
        if(user != null && user.getPageNum() != null){
            PageHelper.startPage(user.getPageNum(),user.getPageSize());
        }
        List<User> list = userMapper.show(Maps.build().beanToMap(user));
        return new PageInfo<User>(list);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int delete(String userId){
        return userMapper.delete(userId);
    }

    @Override
    public int update(User user){
        return userMapper.update(user);
    }

    @Override
    public List<User> search(String userId, String userName, String userType) {
        return userMapper.search(userId, userName, userType);
    }

    @Override
    public List<User> searchStaff(String userType, String enabled) {
        return userMapper.searchStaff(userType, enabled);
    }
}
