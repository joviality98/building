package com.building.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class WorkOrder {
    @Id
    @Column(name = "work_id")
    private String workId;

    /**
     * 工单标题
     */
    private String title;

    /**
     * 工单描述
     */
    private String description;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 当前受理人
     */
    @Column(name = "deal_id")
    private String dealId;

    @Column(name = "deal_tel")
    private String dealTel;

    /**
     * 工单类型
     */
    @Column(name = "work_type")
    private String workType;

    /**
     * 工单状态：0 处理中，1 已完成，-1 待处理
     */
    @Column(name = "work_status")
    private Integer workStatus;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 通知方式
     */
    @Column(name = "notice_type")
    private String noticeType;

    /**
     * 设备id
     */
    @Column(name = "equipment_id")
    private String equipmentId;

    /**
     * 完成时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "end_time")
    private Date endTime;

    /**
     * @return work_id
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * @param workId
     */
    public void setWorkId(String workId) {
        this.workId = workId;
    }

    /**
     * 获取工单标题
     *
     * @return title - 工单标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置工单标题
     *
     * @param title 工单标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取工单描述
     *
     * @return description - 工单描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置工单描述
     *
     * @param description 工单描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取创建者
     *
     * @return creater - 创建者
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 设置创建者
     *
     * @param creater 创建者
     */
    public void setCreater(String creater) {
        this.creater = creater;
    }

    /**
     * 获取当前受理人
     *
     * @return deal_id - 当前受理人
     */
    public String getDealId() {
        return dealId;
    }

    /**
     * 设置当前受理人
     *
     * @param dealId 当前受理人
     */
    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    /**
     * @return deal_tel
     */
    public String getDealTel() {
        return dealTel;
    }

    /**
     * @param dealTel
     */
    public void setDealTel(String dealTel) {
        this.dealTel = dealTel;
    }

    /**
     * 获取工单类型
     *
     * @return work_type - 工单类型
     */
    public String getWorkType() {
        return workType;
    }

    /**
     * 设置工单类型
     *
     * @param workType 工单类型
     */
    public void setWorkType(String workType) {
        this.workType = workType;
    }

    /**
     * 获取工单状态：1 待处理， 2 待接单，3 处理中，4 已完成
     *
     * @return work_status - 工单状态：1 待处理， 2 待接单，3 处理中，4 已完成
     */
    public Integer getWorkStatus() {
        return workStatus;
    }

    /**
     * 设置工单状态：1 待处理， 2 待接单，3 处理中，4 已完成
     *
     * @param workStatus 工单状态：1 待处理， 2 待接单，3 处理中，4 已完成
     */
    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取通知方式
     *
     * @return notice_type - 通知方式
     */
    public String getNoticeType() {
        return noticeType;
    }

    /**
     * 设置通知方式
     *
     * @param noticeType 通知方式
     */
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    /**
     * 获取设备id
     *
     * @return equipment_id - 设备id
     */
    public String getEquipmentId() {
        return equipmentId;
    }

    /**
     * 设置设备id
     *
     * @param equipmentId 设备id
     */
    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    /**
     * 获取完成时间
     *
     * @return end_time - 完成时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置完成时间
     *
     * @param endTime 完成时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}