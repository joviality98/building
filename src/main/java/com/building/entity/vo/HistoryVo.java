package com.building.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class HistoryVo {
    private String historyId;
    private String problem;
    private String creater;
    private String dealId;
    private String workType;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private String equipmentId;
    private String equipmentImg;

    @Override
    public String toString() {
        return "HistoryVo{" +
                "historyId='" + historyId + '\'' +
                ", problem='" + problem + '\'' +
                ", creater='" + creater + '\'' +
                ", dealId='" + dealId + '\'' +
                ", workType='" + workType + '\'' +
                ", createdTime=" + createdTime +
                ", endTime=" + endTime +
                ", equipmentId='" + equipmentId + '\'' +
                ", equipmentImg='" + equipmentImg + '\'' +
                '}';
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentImg() {
        return equipmentImg;
    }

    public void setEquipmentImg(String equipmentImg) {
        this.equipmentImg = equipmentImg;
    }
}
