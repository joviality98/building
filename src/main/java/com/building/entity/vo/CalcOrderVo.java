package com.building.entity.vo;

public class CalcOrderVo {
    private Integer dayTotal;
    private Integer lastDayTotal;
    private Double dayVal;

    private Integer monthTotal;
    private Integer lastMonthTotal;
    private Double monthVal;

    private Integer yearTotal;
    private Integer lastYearTotal;
    private Double yearVal;

    @Override
    public String toString() {
        return "CalcOrderVo{" +
                "dayTotal=" + dayTotal +
                ", lastDayTotal=" + lastDayTotal +
                ", dayVal=" + dayVal +
                ", monthTotal=" + monthTotal +
                ", lastMonthTotal=" + lastMonthTotal +
                ", monthVal=" + monthVal +
                ", yearTotal=" + yearTotal +
                ", lastYearTotal=" + lastYearTotal +
                ", yearVal=" + yearVal +
                '}';
    }

    public Integer getDayTotal() {
        return dayTotal;
    }

    public void setDayTotal(Integer dayTotal) {
        this.dayTotal = dayTotal;
    }

    public Integer getLastDayTotal() {
        return lastDayTotal;
    }

    public void setLastDayTotal(Integer lastDayTotal) {
        this.lastDayTotal = lastDayTotal;
    }


    public Integer getMonthTotal() {
        return monthTotal;
    }

    public void setMonthTotal(Integer monthTotal) {
        this.monthTotal = monthTotal;
    }

    public Integer getLastMonthTotal() {
        return lastMonthTotal;
    }

    public void setLastMonthTotal(Integer lastMonthTotal) {
        this.lastMonthTotal = lastMonthTotal;
    }


    public Integer getYearTotal() {
        return yearTotal;
    }

    public void setYearTotal(Integer yearTotal) {
        this.yearTotal = yearTotal;
    }

    public Integer getLastYearTotal() {
        return lastYearTotal;
    }

    public void setLastYearTotal(Integer lastYearTotal) {
        this.lastYearTotal = lastYearTotal;
    }

    public Double getDayVal() {
        return dayVal;
    }

    public void setDayVal(Double dayVal) {
        this.dayVal = dayVal;
    }

    public Double getMonthVal() {
        return monthVal;
    }

    public void setMonthVal(Double monthVal) {
        this.monthVal = monthVal;
    }

    public Double getYearVal() {
        return yearVal;
    }

    public void setYearVal(Double yearVal) {
        this.yearVal = yearVal;
    }
}
