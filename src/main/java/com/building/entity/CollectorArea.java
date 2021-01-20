package com.building.entity;

import com.building.util.TreeEntity;

import java.util.List;

//采集器
public class CollectorArea implements TreeEntity<CollectorArea> {

    private String id;
    private String label;
    private String parentId;
    private List<CollectorArea> children;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<CollectorArea> getChildren() {
        return children;
    }

    public void setChildren(List<CollectorArea> children) {
        this.children = children;
    }
}
