package com.building.entity;

import com.building.util.Page;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Police extends Page {

    private Integer id;
    private String name;//报警名称
    private Integer type;//报警类型
    private String detail;//报警内容
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;//报警时间
    private boolean deal;//是否处理（1：处理， 0：未处理）

    private Integer today;
    private Integer prop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isDeal() {
        return deal;
    }

    public void setDeal(boolean deal) {
        this.deal = deal;
    }

    public Integer getToday() {
        return today;
    }

    public void setToday(Integer today) {
        this.today = today;
    }

    public Integer getProp() {
        return prop;
    }

    public void setProp(Integer prop) {
        this.prop = prop;
    }
}
