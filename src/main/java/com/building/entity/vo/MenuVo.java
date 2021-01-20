package com.building.entity.vo;

public class MenuVo {
    private String id;
    private String parentName;
    private String parentId;
    private String name;
    private Long sort;
    private String icon;
    private String component;

    @Override
    public String toString() {
        return "MenuVo{" +
                "id='" + id + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", sort=" + sort +'\'' +
                ", icon='" + icon + '\'' +
                ", component='" + component + '\'' +
                '}';
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
}
