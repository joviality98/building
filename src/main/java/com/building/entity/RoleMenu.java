package com.building.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "role_menu")
public class RoleMenu {
    @Id
    private Long id;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "menu_id")
    private String menuId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return menu_id
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}