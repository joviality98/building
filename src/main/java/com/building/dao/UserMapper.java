package com.building.dao;

import com.building.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    //登录
    public User verify(String userName);

    //显示
    public List<User> show(Map<String, Object> paramMap);

    //添加
    public int add(User user);

    //删除
    public int delete(String userId);

    //修改
    public int update(User user);

    //根据id或者userName查找用户信息
    public List<User> search(String userId, String userName, String userType);

    //根据enabled和userType查找用户
    public List<User> searchStaff(String userType, String enabled);
}