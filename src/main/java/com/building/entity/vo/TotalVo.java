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
    private String workType1;
    private String workType2;
    private String workType3;
    private String workStatus1;
    private String workStatus2;
    private String workStatus3;
    private String workStatus4;

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
                ", workType1='" + workType1 + '\'' +
                ", workType2='" + workType2 + '\'' +
                ", workType3='" + workType3 + '\'' +
                ", workStatus1='" + workStatus1 + '\'' +
                ", workStatus2='" + workStatus2 + '\'' +
                ", workStatus3='" + workStatus3 + '\'' +
                ", workStatus4='" + workStatus4 + '\'' +
                '}';
    }

    public String getWorkType1() {
        return workType1;
    }

    public void setWorkType1(String workType1) {
        this.workType1 = workType1;
    }

    public String getWorkType2() {
        return workType2;
    }

    public void setWorkType2(String workType2) {
        this.workType2 = workType2;
    }

    public String getWorkType3() {
        return workType3;
    }

    public void setWorkType3(String workType3) {
        this.workType3 = workType3;
    }

    public String getWorkStatus1() {
        return workStatus1;
    }

    public void setWorkStatus1(String workStatus1) {
        this.workStatus1 = workStatus1;
    }

    public String getWorkStatus2() {
        return workStatus2;
    }

    public void setWorkStatus2(String workStatus2) {
        this.workStatus2 = workStatus2;
    }

    public String getWorkStatus3() {
        return workStatus3;
    }

    public void setWorkStatus3(String workStatus3) {
        this.workStatus3 = workStatus3;
    }

    public String getWorkStatus4() {
        return workStatus4;
    }

    public void setWorkStatus4(String workStatus4) {
        this.workStatus4 = workStatus4;
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
