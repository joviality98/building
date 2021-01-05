package com.building.entity;

import javax.persistence.*;
import java.util.Date;

public class Equipment {
    @Id
    @Column(name = "equipment_id")
    private String equipmentId;

    /**
     * 设备名称
     */
    @Column(name = "equipment_name")
    private String equipmentName;

    /**
     * 设备状态：1 运行正常，0 故障报警
     */
    @Column(name = "equipment_status")
    private Integer equipmentStatus;

    /**
     * 设备型号
     */
    private String type;

    /**
     * 设备规格
     */
    private String specs;

    /**
     * 设备的品牌
     */
    private String brand;

    /**
     * 质保日期
     */
    @Column(name = "QA")
    private Date qa;

    /**
     * 生产时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 位置
     */
    private String position;

    /**
     * 功率
     */
    private Double power;

    /**
     * 电压
     */
    private Double voltage;

    /**
     * 电流
     */
    private Double current;

    /**
     * @return equipment_id
     */
    public String getEquipmentId() {
        return equipmentId;
    }

    /**
     * @param equipmentId
     */
    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    /**
     * 获取设备名称
     *
     * @return equipment_name - 设备名称
     */
    public String getEquipmentName() {
        return equipmentName;
    }

    /**
     * 设置设备名称
     *
     * @param equipmentName 设备名称
     */
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    /**
     * 获取设备状态：1 运行正常，0 故障报警
     *
     * @return equipment_status - 设备状态：1 运行正常，0 故障报警
     */
    public Integer getEquipmentStatus() {
        return equipmentStatus;
    }

    /**
     * 设置设备状态：1 运行正常，0 故障报警
     *
     * @param equipmentStatus 设备状态：1 运行正常，0 故障报警
     */
    public void setEquipmentStatus(Integer equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    /**
     * 获取设备型号
     *
     * @return type - 设备型号
     */
    public String getType() {
        return type;
    }

    /**
     * 设置设备型号
     *
     * @param type 设备型号
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取设备规格
     *
     * @return specs - 设备规格
     */
    public String getSpecs() {
        return specs;
    }

    /**
     * 设置设备规格
     *
     * @param specs 设备规格
     */
    public void setSpecs(String specs) {
        this.specs = specs;
    }

    /**
     * 获取设备的品牌
     *
     * @return brand - 设备的品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置设备的品牌
     *
     * @param brand 设备的品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取质保日期
     *
     * @return QA - 质保日期
     */
    public Date getQa() {
        return qa;
    }

    /**
     * 设置质保日期
     *
     * @param qa 质保日期
     */
    public void setQa(Date qa) {
        this.qa = qa;
    }

    /**
     * 获取生产时间
     *
     * @return created_time - 生产时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置生产时间
     *
     * @param createdTime 生产时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取位置
     *
     * @return position - 位置
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置位置
     *
     * @param position 位置
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取功率
     *
     * @return power - 功率
     */
    public Double getPower() {
        return power;
    }

    /**
     * 设置功率
     *
     * @param power 功率
     */
    public void setPower(Double power) {
        this.power = power;
    }

    /**
     * 获取电压
     *
     * @return voltage - 电压
     */
    public Double getVoltage() {
        return voltage;
    }

    /**
     * 设置电压
     *
     * @param voltage 电压
     */
    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    /**
     * 获取电流
     *
     * @return current - 电流
     */
    public Double getCurrent() {
        return current;
    }

    /**
     * 设置电流
     *
     * @param current 电流
     */
    public void setCurrent(Double current) {
        this.current = current;
    }
}