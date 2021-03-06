package com.building.entity;

import com.building.util.Page;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VariantData extends Page {

    private Integer variantId;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date countTime;
    private double countValue;
    private int countType;
    private String time;

    private CollectorArea collectorArea;
    private Collector collector;
    private Meter meter;
    private Variant variant;
    private double lastValue;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date laTime;//lastTime
    private double thisValue;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date thTime;//lastTime;

    public Integer getVariantId() {
        return variantId;
    }

    public void setVariantId(Integer variantId) {
        this.variantId = variantId;
    }

    public Date getCountTime() {
        return countTime;
    }

    public void setCountTime(Date countTime) {
        this.countTime = countTime;
    }

    public double getCountValue() {
        return countValue;
    }

    public void setCountValue(double countValue) {
        this.countValue = countValue;
    }

    public int getCountType() {
        return countType;
    }

    public void setCountType(int countType) {
        this.countType = countType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CollectorArea getCollectorArea() {
        return collectorArea;
    }

    public void setCollectorArea(CollectorArea collectorArea) {
        this.collectorArea = collectorArea;
    }

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public double getLastValue() {
        return lastValue;
    }

    public void setLastValue(double lastValue) {
        this.lastValue = lastValue;
    }

    public Date getLaTime() {
        return laTime;
    }

    public void setLaTime(Date laTime) {
        this.laTime = laTime;
    }

    public double getThisValue() {
        return thisValue;
    }

    public void setThisValue(double thisValue) {
        this.thisValue = thisValue;
    }

    public Date getThTime() {
        return thTime;
    }

    public void setThTime(Date thTime) {
        this.thTime = thTime;
    }
}
