package com.building.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "order_history")
public class OrderHistory {
    @Id
    @Column(name = "history_id")
    private String historyId;

    /**
     * 工单问题
     */
    private String problem;

    /**
     * 工单备注
     */
    private String remark;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 受理人
     */
    @Column(name = "deal_id")
    private String dealId;

    /**
     * 工单类型
     */
    @Column(name = "work_type")
    private String workType;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 完成时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 设备id
     */
    @Column(name = "equipment_id")
    private String equipmentId;

    /**
     * 设备照片
     */
    @Column(name = "equipment_img")
    private String equipmentImg;

    /**
     * @return history_id
     */
    public String getHistoryId() {
        return historyId;
    }

    /**
     * @param historyId
     */
    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    /**
     * 获取工单问题
     *
     * @return problem - 工单问题
     */
    public String getProblem() {
        return problem;
    }

    /**
     * 设置工单问题
     *
     * @param problem 工单问题
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * 获取工单备注
     *
     * @return remark - 工单备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置工单备注
     *
     * @param remark 工单备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * 获取受理人
     *
     * @return deal_id - 受理人
     */
    public String getDealId() {
        return dealId;
    }

    /**
     * 设置受理人
     *
     * @param dealId 受理人
     */
    public void setDealId(String dealId) {
        this.dealId = dealId;
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
     * 获取设备照片
     *
     * @return equipment_img - 设备照片
     */
    public String getEquipmentImg() {
        return equipmentImg;
    }

    /**
     * 设置设备照片
     *
     * @param equipmentImg 设备照片
     */
    public void setEquipmentImg(String equipmentImg) {
        this.equipmentImg = equipmentImg;
    }
}