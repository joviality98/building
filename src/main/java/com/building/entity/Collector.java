package com.building.entity;

public class Collector {

    private String id;
//    private String gatewayId;
    private String label;
    private String ip;
    private String port;
    private String remark;
    private int status;  //采集器状态（1：正常，0：异常），默认异常
//    private int equipId;
    private String collectorAreaId;

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

    public String getCollectorAreaId() {
        return collectorAreaId;
    }

    public void setCollectorAreaId(String collectorAreaId) {
        this.collectorAreaId = collectorAreaId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
