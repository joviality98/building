package com.building.service.impl;

import com.building.dao.RoleMapper;
import com.building.dao.RoleMenuMapper;
import com.building.dao.UserRoleMapper;
import com.building.entity.Role;
import com.building.entity.RoleMenu;
import com.building.entity.UserRole;
import com.building.entity.vo.RolePermissionVo;
import com.building.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CDSY
 * @since 2020-12-15
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper mapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Override
    public void saveRole(Role role) {
        mapper.insertSelective(role);
    }

    @Override
    public void updateRole(Role role) {
        mapper.updateByPrimaryKey(role);
    }

    @Override
    public void deleteRole(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Role> getRolesByUsername(String username) {
        return mapper.getRolesByUserName(username);
    }

    @Override
    public List<RolePermissionVo> getRoleAndUserList(String roleId) {
        return mapper.getRoleAndUserList(roleId);
    }

    @Override
    public List<RolePermissionVo> getRoleAndMenuList(String roleId) {
        System.out.println("拿到某角色的菜单权限=============");
        System.out.println(mapper.getRoleAndMenuList(roleId));
        return mapper.getRoleAndMenuList(roleId);
    }

    @Override
    public void saveRoleUser(String roleId, List<String> lists) {
        System.out.println("添加角色-用户关联 roleid="+roleId);
        deleteRoleUser(roleId);
        if(lists != null){
            for(String str:lists){
                UserRole userRole = new UserRole();
                userRole.setUserId(str);
                userRole.setRoleId(roleId);
                userRoleMapper.insertSelective(userRole);
            }
        }

    }

    @Override
    public void deleteRoleUser(String id) {
        System.out.println("======进入删除操作======="+id);
        UserRole role = new UserRole();
        role.setRoleId(id);
        userRoleMapper.delete(role);
    }

    @Override
    public void saveRoleMenu(String roleId, List<String> lists) {
        deleteRoleMenu(roleId);
        if(lists != null){
            for(String str:lists){
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setMenuId(str);
                roleMenu.setRoleId(roleId);
                roleMenuMapper.insertSelective(roleMenu);
            }
        }
    }

    @Override
    public void deleteRoleMenu(String id) {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(id);
        roleMenuMapper.delete(roleMenu);
    }

    @Override
    public List<Role> getAll() {
        return mapper.selectAll();
    }
}
