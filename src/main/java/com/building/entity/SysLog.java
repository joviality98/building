package com.building.entity;


import com.building.util.Page;

import java.util.Date;

//系统日志
public class SysLog extends Page {

    private Integer id;
    private String userName;
    private String methods;
    private String descs;
    private String ip;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
