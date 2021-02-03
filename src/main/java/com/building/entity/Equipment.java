package com.building.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Equipment {
    /**
     * 设备id
     */
    @Id
    @Column(name = "equipment_id")
    private String equipmentId;

    /**
     * 设备名称
     */
    @Column(name = "equipment_name")
    private String equipmentName;

    /**
     * 设备状态：1在用，2已销账，3维修，4其他自定义类型
     */
    @Column(name = "equipment_status")
    private Integer equipmentStatus;

    /**
     * 规格型号
     */
    private String model;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 生成日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 采购日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @Column(name = "stock_time")
    private Date stockTime;

    /**
     * 安装位置
     */
    private String position;

    /**
     * 价格
     */
    private Double price;

    /**
     * 财务编号
     */
    @Column(name = "ser_id")
    private String serId;

    /**
     * 种类编码
     */
    @Column(name = "kind_id")
    private String kindId;

    @Column(name = "kind_name")
    private String kindName;

    /**
     * 生产商
     */
    private String fac;

    /**
     * 供应商
     */
    private String acc;

    /**
     * 部门id
     */
    @Column(name = "dept_id")
    private String deptId;

    /**
     * 部门名称
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 责任人
     */
    private String chargeby;

    /**
     * 购买人
     */
    @Column(name = "buy_prs")
    private String buyPrs;

    /**
     * 用途
     */
    @Column(name = "use_to")
    private String useTo;

    private String sourse;

    /**
     * 原值
     */
    @Column(name = "total_fee")
    private String totalFee;

    /**
     * 折旧方法 0，1，2
     */
    @Column(name = "depre_type")
    private Integer depreType;

    /**
     * 预计使用月份(60)
     */
    @Column(name = "pre_depreciation_moon")
    private Integer preDepreciationMoon;

    /**
     * 预计净残值率%
     */
    @Column(name = "salvage_value_rate")
    private Double salvageValueRate;

    /**
     * 维修截止日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @Column(name = "mainten_end_time")
    private Date maintenEndTime;

    /**
     * 报废截止日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @Column(name = "reject_end_time")
    private Date rejectEndTime;

    /**
     * 销账日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @Column(name = "discard_time")
    private Date discardTime;

    /**
     * 销账类型：1报废、2丢失、3赠送等
     */
    @Column(name = "discard_type")
    private Integer discardType;

    /**
     * 检修频率数
     */
    @Column(name = "freq_count")
    private Double freqCount;

    /**
     * 检修频率单位：year年，month月，day天，week周
     */
    @Column(name = "freq_unit")
    private String freqUnit;

    /**
     * 下次维修日期
     */
    @Column(name = "next_check_time")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date nextCheckTime;

    private String chejian;

    private String chanxian;

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId='" + equipmentId + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentStatus=" + equipmentStatus +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", createdTime=" + createdTime +
                ", stockTime=" + stockTime +
                ", position='" + position + '\'' +
                ", price=" + price +
                ", serId='" + serId + '\'' +
                ", kindId='" + kindId + '\'' +
                ", kindName='" + kindName + '\'' +
                ", fac='" + fac + '\'' +
                ", acc='" + acc + '\'' +
                ", deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", chargeby='" + chargeby + '\'' +
                ", buyPrs='" + buyPrs + '\'' +
                ", useTo='" + useTo + '\'' +
                ", sourse='" + sourse + '\'' +
                ", totalFee='" + totalFee + '\'' +
                ", depreType=" + depreType +
                ", preDepreciationMoon=" + preDepreciationMoon +
                ", salvageValueRate=" + salvageValueRate +
                ", maintenEndTime=" + maintenEndTime +
                ", rejectEndTime=" + rejectEndTime +
                ", discardTime=" + discardTime +
                ", discardType=" + discardType +
                ", freqCount=" + freqCount +
                ", freqUnit='" + freqUnit + '\'' +
                ", nextCheckTime=" + nextCheckTime +
                ", chejian='" + chejian + '\'' +
                ", chanxian='" + chanxian + '\'' +
                '}';
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
     * 获取设备状态：1在用，2已销账，3维修，4其他自定义类型
     *
     * @return equipment_status - 设备状态：1在用，2已销账，3维修，4其他自定义类型
     */
    public Integer getEquipmentStatus() {
        return equipmentStatus;
    }

    /**
     * 设置设备状态：1在用，2已销账，3维修，4其他自定义类型
     *
     * @param equipmentStatus 设备状态：1在用，2已销账，3维修，4其他自定义类型
     */
    public void setEquipmentStatus(Integer equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    /**
     * 获取规格型号
     *
     * @return model - 规格型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置规格型号
     *
     * @param model 规格型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取品牌
     *
     * @return brand - 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置品牌
     *
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取生成日期
     *
     * @return created_time - 生成日期
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置生成日期
     *
     * @param createdTime 生成日期
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取采购日期
     *
     * @return stock_time - 采购日期
     */
    public Date getStockTime() {
        return stockTime;
    }

    /**
     * 设置采购日期
     *
     * @param stockTime 采购日期
     */
    public void setStockTime(Date stockTime) {
        this.stockTime = stockTime;
    }

    /**
     * 获取安装位置
     *
     * @return position - 安装位置
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置安装位置
     *
     * @param position 安装位置
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取财务编号
     *
     * @return ser_id - 财务编号
     */
    public String getSerId() {
        return serId;
    }

    /**
     * 设置财务编号
     *
     * @param serId 财务编号
     */
    public void setSerId(String serId) {
        this.serId = serId;
    }

    /**
     * 获取种类编码
     *
     * @return kind_id - 种类编码
     */
    public String getKindId() {
        return kindId;
    }

    /**
     * 设置种类编码
     *
     * @param kindId 种类编码
     */
    public void setKindId(String kindId) {
        this.kindId = kindId;
    }

    /**
     * @return kind_name
     */
    public String getKindName() {
        return kindName;
    }

    /**
     * @param kindName
     */
    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    /**
     * 获取生产商
     *
     * @return fac - 生产商
     */
    public String getFac() {
        return fac;
    }

    /**
     * 设置生产商
     *
     * @param fac 生产商
     */
    public void setFac(String fac) {
        this.fac = fac;
    }

    /**
     * 获取供应商
     *
     * @return acc - 供应商
     */
    public String getAcc() {
        return acc;
    }

    /**
     * 设置供应商
     *
     * @param acc 供应商
     */
    public void setAcc(String acc) {
        this.acc = acc;
    }

    /**
     * 获取部门id
     *
     * @return dept_id - 部门id
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取部门名称
     *
     * @return dept_name - 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置部门名称
     *
     * @param deptName 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取责任人
     *
     * @return chargeby - 责任人
     */
    public String getChargeby() {
        return chargeby;
    }

    /**
     * 设置责任人
     *
     * @param chargeby 责任人
     */
    public void setChargeby(String chargeby) {
        this.chargeby = chargeby;
    }

    /**
     * 获取购买人
     *
     * @return buy_prs - 购买人
     */
    public String getBuyPrs() {
        return buyPrs;
    }

    /**
     * 设置购买人
     *
     * @param buyPrs 购买人
     */
    public void setBuyPrs(String buyPrs) {
        this.buyPrs = buyPrs;
    }

    /**
     * 获取用途
     *
     * @return use_to - 用途
     */
    public String getUseTo() {
        return useTo;
    }

    /**
     * 设置用途
     *
     * @param useTo 用途
     */
    public void setUseTo(String useTo) {
        this.useTo = useTo;
    }

    /**
     * @return sourse
     */
    public String getSourse() {
        return sourse;
    }

    /**
     * @param sourse
     */
    public void setSourse(String sourse) {
        this.sourse = sourse;
    }

    /**
     * 获取原值
     *
     * @return total_fee - 原值
     */
    public String getTotalFee() {
        return totalFee;
    }

    /**
     * 设置原值
     *
     * @param totalFee 原值
     */
    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 获取折旧方法 0，1，2
     *
     * @return depre_type - 折旧方法 0，1，2
     */
    public Integer getDepreType() {
        return depreType;
    }

    /**
     * 设置折旧方法 0，1，2
     *
     * @param depreType 折旧方法 0，1，2
     */
    public void setDepreType(Integer depreType) {
        this.depreType = depreType;
    }

    /**
     * 获取预计使用月份(60)
     *
     * @return pre_depreciation_moon - 预计使用月份(60)
     */
    public Integer getPreDepreciationMoon() {
        return preDepreciationMoon;
    }

    /**
     * 设置预计使用月份(60)
     *
     * @param preDepreciationMoon 预计使用月份(60)
     */
    public void setPreDepreciationMoon(Integer preDepreciationMoon) {
        this.preDepreciationMoon = preDepreciationMoon;
    }

    /**
     * 获取预计净残值率%
     *
     * @return salvage_value_rate - 预计净残值率%
     */
    public Double getSalvageValueRate() {
        return salvageValueRate;
    }

    /**
     * 设置预计净残值率%
     *
     * @param salvageValueRate 预计净残值率%
     */
    public void setSalvageValueRate(Double salvageValueRate) {
        this.salvageValueRate = salvageValueRate;
    }

    /**
     * 获取维修截止日期
     *
     * @return mainten_end_time - 维修截止日期
     */
    public Date getMaintenEndTime() {
        return maintenEndTime;
    }

    /**
     * 设置维修截止日期
     *
     * @param maintenEndTime 维修截止日期
     */
    public void setMaintenEndTime(Date maintenEndTime) {
        this.maintenEndTime = maintenEndTime;
    }

    /**
     * 获取报废截止日期
     *
     * @return reject_end_time - 报废截止日期
     */
    public Date getRejectEndTime() {
        return rejectEndTime;
    }

    /**
     * 设置报废截止日期
     *
     * @param rejectEndTime 报废截止日期
     */
    public void setRejectEndTime(Date rejectEndTime) {
        this.rejectEndTime = rejectEndTime;
    }

    /**
     * 获取销账日期
     *
     * @return discard_time - 销账日期
     */
    public Date getDiscardTime() {
        return discardTime;
    }

    /**
     * 设置销账日期
     *
     * @param discardTime 销账日期
     */
    public void setDiscardTime(Date discardTime) {
        this.discardTime = discardTime;
    }

    /**
     * 获取销账类型：1报废、2丢失、3赠送等
     *
     * @return discard_type - 销账类型：1报废、2丢失、3赠送等
     */
    public Integer getDiscardType() {
        return discardType;
    }

    /**
     * 设置销账类型：1报废、2丢失、3赠送等
     *
     * @param discardType 销账类型：1报废、2丢失、3赠送等
     */
    public void setDiscardType(Integer discardType) {
        this.discardType = discardType;
    }

    /**
     * 获取检修频率数
     *
     * @return freq_count - 检修频率数
     */
    public Double getFreqCount() {
        return freqCount;
    }

    /**
     * 设置检修频率数
     *
     * @param freqCount 检修频率数
     */
    public void setFreqCount(Double freqCount) {
        this.freqCount = freqCount;
    }

    /**
     * 获取检修频率单位：year年，month月，day天，week周
     *
     * @return freq_unit - 检修频率单位：year年，month月，day天，week周
     */
    public String getFreqUnit() {
        return freqUnit;
    }

    /**
     * 设置检修频率单位：year年，month月，day天，week周
     *
     * @param freqUnit 检修频率单位：year年，month月，day天，week周
     */
    public void setFreqUnit(String freqUnit) {
        this.freqUnit = freqUnit;
    }

    /**
     * 获取下次维修日期
     *
     * @return next_check_time - 下次维修日期
     */
    public Date getNextCheckTime() {
        return nextCheckTime;
    }

    /**
     * 设置下次维修日期
     *
     * @param nextCheckTime 下次维修日期
     */
    public void setNextCheckTime(Date nextCheckTime) {
        this.nextCheckTime = nextCheckTime;
    }

    /**
     * @return chejian
     */
    public String getChejian() {
        return chejian;
    }

    /**
     * @param chejian
     */
    public void setChejian(String chejian) {
        this.chejian = chejian;
    }

    /**
     * @return chanxian
     */
    public String getChanxian() {
        return chanxian;
    }

    /**
     * @param chanxian
     */
    public void setChanxian(String chanxian) {
        this.chanxian = chanxian;
    }
}