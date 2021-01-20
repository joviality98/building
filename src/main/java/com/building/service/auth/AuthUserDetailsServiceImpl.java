package com.building.service.auth;

import com.building.entity.Role;
import com.building.entity.User;
import com.building.service.RoleService;
import com.building.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 要实现UserDetailsService接口，这个接口是security提供的
 */
@Service
public class AuthUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 通过账号查找用户、角色的信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.verify(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", username));
        }else {
            //查找角色
            List<Role> roles =  roleService.getRolesByUsername(username);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            System.out.println("loadUserByUsername......user ===> " + user);
            return new AuthUser(user.getUserName(), user.getPassword(), user.getLocked(), authorities);
        }
    }
}
