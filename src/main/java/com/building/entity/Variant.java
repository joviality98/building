package com.building.entity;

public class Variant {

    private Integer id;
//    private String variantId;
    private String label;
    private String addr;
//    private String addr16;
//    private String type;
    private String collectorId;
    private String meterId;
//    private String parameterId;
//    private String enable;
    private String unit;
//    private String varType;
//    private int remember;
//    private String timeIntervel;
//    private String controlValue;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(String collectorId) {
        this.collectorId = collectorId;
    }

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
