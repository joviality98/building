package com.building.entity.vo;

public class ApiVo {
    private String id;
    private String parentName;
    private String pid;
    private String name;
    private int sort;
    private String url;
    private String description;

    @Override
    public String toString() {
        return "ApiVo{" +
                "id='" + id + '\'' +
                ", parentName='" + parentName + '\'' +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
