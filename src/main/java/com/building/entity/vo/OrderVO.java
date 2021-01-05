package com.building.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderVO {
    private String workId;
    private String title;
    private String description;
    private String creater;
    private String dealId;
    private String dealTel;
    private String workType;
    private Integer workStatus;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    private String noticeType;
    private String equipmentId;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @Override
    public String toString() {
        return "OrderVO{" +
                "workId='" + workId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creater='" + creater + '\'' +
                ", dealId='" + dealId + '\'' +
                ", dealTel='" + dealTel + '\'' +
                ", workType='" + workType + '\'' +
                ", workStatus=" + workStatus +
                ", createdTime=" + createdTime +
                ", noticeType='" + noticeType + '\'' +
                ", equipmentId='" + equipmentId + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDealTel() {
        return dealTel;
    }

    public void setDealTel(String dealTel) {
        this.dealTel = dealTel;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Integer getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
