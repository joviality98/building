package com.building.entity;

import com.building.util.TreeEntity;

import java.util.List;

public class Area implements TreeEntity<Area> {
    private String id;
    private String parentId;
    private String label;
//    private String code;
//    private String leaf;
//    private String position;
//    private String remark;

    private List<Area> children;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Area> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<Area> children) {
        this.children = children;
    }
}
