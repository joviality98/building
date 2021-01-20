package com.building.controller;

import com.alibaba.fastjson.JSONObject;
import com.building.common.lang.Result;
import com.building.components.BCryptPasswordEncoderUtil;
import com.building.entity.Menu;
import com.building.entity.User;
import com.building.entity.vo.MenuVo;
import com.building.log.MyLog;
import com.building.service.MenuService;
import com.building.service.UserService;
import com.building.util.Entity2VO;
import com.building.util.JwtUtil;
import com.building.util.TreeUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public Result loginStatus(HttpServletRequest request, HttpSession session){
        System.out.println("request = "+request);
        JSONObject jsonObject = new JSONObject();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        User u = userService.verify(userName);
        if(u == null){
            return Result.fail("用户不存在");
        }
        //生成Jwt令牌
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        String token = JwtUtil.sign(user);
        if(!bCryptPasswordEncoderUtil.matches(password,u.getPassword())){
            return Result.fail("密码不正确");
        }

        u.setEnabled("1");
        userService.update(u);

        List<Menu> menus = menuService.getMenuByUsername(userName);
        List<MenuVo> listVO = Entity2VO.entityList2VOList(menus, MenuVo.class);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("menus",TreeUtils.toTree(listVO));
        map.put("token",token);
        return Result.success("登录成功",map);
    }

    @RequestMapping(value = "/user/show",method = RequestMethod.GET)
    public Result show(User user){
        PageInfo<User> pageInfo = userService.show(user);
        return Result.success(pageInfo);
    }
    @MyLog("增加用户")
    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public Result add(@RequestBody User user){
        Object obj = userService.add(user);
        return Result.success(obj);
    }

    @MyLog("删除用户")
    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
    public Result delete(String userId){
        return Result.success(userService.delete(userId));
    }

    @MyLog("修改用户信息")
    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public Result update(@RequestBody User user){
        return Result.success(userService.update(user));
    }

    @MyLog("搜索用户")
    @RequestMapping(value = "/user/search",method = RequestMethod.GET)
    public Result search(String userId, String userName, String userType){
        return Result.success(userService.search(userId, userName, userType));
    }

    @RequestMapping(value = "/user/searchStaff",method = RequestMethod.GET)
    public Result searchStaff(String userType, String enabled){
        return Result.success(userService.searchStaff(userType, enabled));
    }
    @PostMapping("/user/logout")
    public Result logout(@RequestBody HashMap<String, String> map){

        User user = userService.search("",map.get("name"),"").get(0);
        user.setEnabled("0");
        userService.update(user);

        return Result.success();
    }
}
