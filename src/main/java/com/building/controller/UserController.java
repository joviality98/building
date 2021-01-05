package com.building.controller;

import com.alibaba.fastjson.JSONObject;
import com.building.common.lang.Result;
import com.building.entity.User;
import com.building.service.UserService;
import com.building.util.Consts;
import com.building.util.JwtUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        boolean flag = userService.verify(userName,password);
        //生成Jwt令牌
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        String token = JwtUtil.sign(user);

        

        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"登录成功");
            jsonObject.put("token",token);
            session.setAttribute(Consts.Name,userName);
            return jsonObject;
        }
        else{
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名或密码错误");
            return jsonObject;
        }
    }

    @RequestMapping(value = "/user/show",method = RequestMethod.GET)
    public Result show(User user){
        PageInfo<User> pageInfo = userService.show(user);
        return Result.success(pageInfo);
    }

    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public Result add(@RequestBody User user){
        Object obj = userService.add(user);
        return Result.success(obj);
    }

    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
    public Result delete(String userId){
        return Result.success(userService.delete(userId));
    }

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public Result update(@RequestBody User user){
        return Result.success(userService.update(user));
    }

    @RequestMapping(value = "/user/search",method = RequestMethod.GET)
    public Result search(String userId, String userName, String userType){
        return Result.success(userService.search(userId, userName, userType));
    }

    @RequestMapping(value = "/user/searchStaff",method = RequestMethod.GET)
    public Result searchStaff(String userType, String enabled){
        return Result.success(userService.searchStaff(userType, enabled));
    }
}
