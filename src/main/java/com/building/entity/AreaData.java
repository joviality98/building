package com.building.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AreaData{

    private int areaId;
    //区域能耗值
    private double countValue;
    //计算区域能耗时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date countTime;

    //能耗类型（'0'：每刻，'1'：每时，'2'：每天，'3'：每月，'4'：每年）
    private int countType;
    private String energyId;
    private double TB;
    private double HB;
    private String dates;
    private String months;
    private double allValue;

    private double thisValue;
    private double lastValue;

    private String dayValue;
    private String monthValue;
    private String yearValue;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public double getCountValue() {
        return countValue;
    }

    public void setCountValue(double countValue) {
        this.countValue = countValue;
    }

    public Date getCountTime() {
        return countTime;
    }

    public void setCountTime(Date countTime) {
        this.countTime = countTime;
    }

    public int getCountType() {
        return countType;
    }

    public void setCountType(int countType) {
        this.countType = countType;
    }

    public String getEnergyId() {
        return energyId;
    }

    public void setEnergyId(String energyId) {
        this.energyId = energyId;
    }

    public double getTB() {
        return TB;
    }

    public void setTB(double TB) {
        this.TB = TB;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public double getAllValue() {
        return allValue;
    }

    public void setAllValue(double allValue) {
        this.allValue = allValue;
    }

    public String getDayValue() {
        return dayValue;
    }

    public void setDayValue(String dayValue) {
        this.dayValue = dayValue;
    }

    public String getMonthValue() {
        return monthValue;
    }

    public void setMonthValue(String monthValue) {
        this.monthValue = monthValue;
    }

    public String getYearValue() {
        return yearValue;
    }

    public void setYearValue(String yearValue) {
        this.yearValue = yearValue;
    }

    public double getHB() {
        return HB;
    }

    public void setHB(double HB) {
        this.HB = HB;
    }

    public double getThisValue() {
        return thisValue;
    }

    public void setThisValue(double thisValue) {
        this.thisValue = thisValue;
    }

    public double getLastValue() {
        return lastValue;
    }

    public void setLastValue(double lastValue) {
        this.lastValue = lastValue;
    }
}
