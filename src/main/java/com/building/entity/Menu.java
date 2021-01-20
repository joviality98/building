package com.building.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Menu {
    @Id
    private String id;

    private String name;

    private String component;

    @Column(name = "parent_id")
    private String parentId;

    private Long sort;

    private String icon;

    private String path;

    private Long cache;

    private Long hidden;

    @Column(name = "component_name")
    private String componentName;

    @Column(name = "create_time")
    private Date createTime;

    private String permission;

    private Integer type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return component
     */
    public String getComponent() {
        return component;
    }

    /**
     * @param component
     */
    public void setComponent(String component) {
        this.component = component;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return sort
     */
    public Long getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return cache
     */
    public Long getCache() {
        return cache;
    }

    /**
     * @param cache
     */
    public void setCache(Long cache) {
        this.cache = cache;
    }

    /**
     * @return hidden
     */
    public Long getHidden() {
        return hidden;
    }

    /**
     * @param hidden
     */
    public void setHidden(Long hidden) {
        this.hidden = hidden;
    }

    /**
     * @return component_name
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * @param componentName
     */
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }
}