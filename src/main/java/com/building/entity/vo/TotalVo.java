package com.building.entity.vo;

public class TotalVo {
    private Integer total;
    private String year;
    private String month;
    private String day;
    private String userName;
    private String weekDay;
    private String workStatus;
    private String workType;

    @Override
    public String toString() {
        return "TotalVo{" +
                "total=" + total +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", userName='" + userName + '\'' +
                ", weekDay='" + weekDay + '\'' +
                ", workStatus='" + workStatus + '\'' +
                ", workType='" + workType + '\'' +
                '}';
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
