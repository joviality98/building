package com.building.config;


import com.building.entity.User;
import com.building.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        // 添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //收起暂时不写
        return simpleAuthorizationInfo;
    }

    //认证用户
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;//判断用户名
        String userName= (String) authenticationToken.getPrincipal();
        System.out.println(userName);
        List<User> userlist = userService.search("", userName, "");
        User user = userlist.get(0);
        System.out.println("----->>user="+user);
        if(user == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(), //用户名
                user.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }

}
