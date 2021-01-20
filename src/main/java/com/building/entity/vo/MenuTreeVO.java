package com.building.entity.vo;

import java.util.List;

public class MenuTreeVO extends MenuVo{
    private List<MenuVo> children;

    @Override
    public String toString() {
        return "MenuTreeVO{" +
                "children=" + children +
                '}';
    }

    public List<MenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVo> children) {
        this.children = children;
    }
}
