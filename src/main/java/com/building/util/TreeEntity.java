package com.building.util;

import java.util.List;

public interface TreeEntity<E> {
    public String getId();

    public String getParentId();

    public void setChildren(List<E> children);
}
