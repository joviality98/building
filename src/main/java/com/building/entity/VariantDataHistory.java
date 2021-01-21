package com.building.entity;

import java.util.Date;

public class VariantDataHistory {

    private int VariantId;
    private String collectValue;
    private Date collectTime;

    public int getVariantId() {
        return VariantId;
    }

    public void setVariantId(int variantId) {
        VariantId = variantId;
    }

    public String getCollectValue() {
        return collectValue;
    }

    public void setCollectValue(String collectValue) {
        this.collectValue = collectValue;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}
