package com.building.service;

import com.building.entity.Role;
import com.building.entity.vo.RolePermissionVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CDSY
 * @since 2020-12-15
 */
public interface RoleService {
    void saveRole(Role role);
    void updateRole(Role role);
    void deleteRole(String id);

    /**
     * 通过用户名查找角色
     * @param username
     * @return
     */
    List<Role> getRolesByUsername(String username);

    /**
     * 根据roleid查找用户
     * @param roleId
     * @return
     */
    List<RolePermissionVo> getRoleAndUserList(String roleId);

    /**
     * 根据roleid查找菜单
     * @param roleId
     * @return
     */
    List<RolePermissionVo> getRoleAndMenuList(String roleId);

    /**
     * 批量保存角色-用户
     * @param roleId
     * @param list
     */
    void saveRoleUser(String roleId,List<String> list);

    /**
     * 通过roleid删除角色-用户关联表的数据
     * @param id
     */
    void deleteRoleUser(String id);

    /**
     * 批量保存角色-菜单
     * @param roleId
     * @param list
     */
    void saveRoleMenu(String roleId,List<String> list);

    /**
     * 通过roleid删除角色-菜单关联表的数据
     * @param id
     */
    void deleteRoleMenu(String id);

    List<Role> getAll();
}
