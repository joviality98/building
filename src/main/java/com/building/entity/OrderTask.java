package com.building.entity;

import javax.persistence.*;

@Table(name = "order_task")
public class OrderTask {
    /**
     * 工作流id
     */
    @Id
    @Column(name = "flow_id")
    private String flowId;

    @Column(name = "work_id")
    private String workId;

    /**
     * 工作流名称
     */
    @Column(name = "flow_name")
    private String flowName;

    /**
     * 处理人id
     */
    @Column(name = "deal_id")
    private String dealId;

    /**
     * 部门id
     */
    @Column(name = "part_id")
    private String partId;

    /**
     * 优先级：1 普通，2 紧急，3 非常紧急
     */
    private Integer priority;

    /**
     * 工单结果状态：1 通过，0 拒绝
     */
    @Column(name = "result_code")
    private Integer resultCode;

    /**
     * 工单处理结果内容
     */
    @Column(name = "result_content")
    private String resultContent;

    /**
     * 工单处理结果图片路径
     */
    @Column(name = "result_img")
    private String resultImg;

    /**
     * 获取工作流id
     *
     * @return flow_id - 工作流id
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     * 设置工作流id
     *
     * @param flowId 工作流id
     */
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

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
     * 获取工作流名称
     *
     * @return flow_name - 工作流名称
     */
    public String getFlowName() {
        return flowName;
    }

    /**
     * 设置工作流名称
     *
     * @param flowName 工作流名称
     */
    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    /**
     * 获取处理人id
     *
     * @return deal_id - 处理人id
     */
    public String getDealId() {
        return dealId;
    }

    /**
     * 设置处理人id
     *
     * @param dealId 处理人id
     */
    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    /**
     * 获取部门id
     *
     * @return part_id - 部门id
     */
    public String getPartId() {
        return partId;
    }

    /**
     * 设置部门id
     *
     * @param partId 部门id
     */
    public void setPartId(String partId) {
        this.partId = partId;
    }

    /**
     * 获取优先级：1 普通，2 紧急，3 非常紧急
     *
     * @return priority - 优先级：1 普通，2 紧急，3 非常紧急
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置优先级：1 普通，2 紧急，3 非常紧急
     *
     * @param priority 优先级：1 普通，2 紧急，3 非常紧急
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取工单结果状态：1 通过，0 拒绝
     *
     * @return result_code - 工单结果状态：1 通过，0 拒绝
     */
    public Integer getResultCode() {
        return resultCode;
    }

    /**
     * 设置工单结果状态：1 通过，0 拒绝
     *
     * @param resultCode 工单结果状态：1 通过，0 拒绝
     */
    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 获取工单处理结果内容
     *
     * @return result_content - 工单处理结果内容
     */
    public String getResultContent() {
        return resultContent;
    }

    /**
     * 设置工单处理结果内容
     *
     * @param resultContent 工单处理结果内容
     */
    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }

    /**
     * 获取工单处理结果图片路径
     *
     * @return result_img - 工单处理结果图片路径
     */
    public String getResultImg() {
        return resultImg;
    }

    /**
     * 设置工单处理结果图片路径
     *
     * @param resultImg 工单处理结果图片路径
     */
    public void setResultImg(String resultImg) {
        this.resultImg = resultImg;
    }
}