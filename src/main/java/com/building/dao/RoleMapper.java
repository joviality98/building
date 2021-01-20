package com.building.dao;


import com.building.entity.Role;
import com.building.entity.vo.RolePermissionVo;
import com.building.util.MyMapper;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {

    List<Role> getRolesByUserName(String username);

    List<RolePermissionVo> getRoleAndUserList(String roleId);

    List<RolePermissionVo> getRoleAndMenuList(String roleId);

    void saveRoleUser(String roleId,String userId);
}