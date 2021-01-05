package com.building.service;

import com.building.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    //按id查找用户
//    User searchUserById(String id);

    public boolean verify(String userName,String password);

    public PageInfo<User> show(User user);

    public int add(User user);

    public int delete(String userId);

    public int update(User user);

    public List<User> search(String userId, String userName, String userType);

    public List<User> searchStaff(String userType, String enabled);


}
