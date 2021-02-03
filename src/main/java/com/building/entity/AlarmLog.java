package com.building.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "alarm_log")
public class AlarmLog {
    @Id
    @Column(name = "Source")
    private String source;

    @Column(name = "Severity")
    private Integer severity;

    @Column(name = "Area")
    private String area;

    @Column(name = "ActiveTime")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date activetime;

    @Column(name = "EventTime")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date eventtime;

    @Column(name = "Message")
    private String message;

    @Override
    public String toString() {
        return "AlarmLog{" +
                "source='" + source + '\'' +
                ", severity=" + severity +
                ", area='" + area + '\'' +
                ", activetime=" + activetime +
                ", eventtime=" + eventtime +
                ", message='" + message + '\'' +
                '}';
    }

    /**
     * @return Source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return Severity
     */
    public Integer getSeverity() {
        return severity;
    }

    /**
     * @param severity
     */
    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    /**
     * @return Area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return ActiveTime
     */
    public Date getActivetime() {
        return activetime;
    }

    /**
     * @param activetime
     */
    public void setActivetime(Date activetime) {
        this.activetime = activetime;
    }

    /**
     * @return EventTime
     */
    public Date getEventtime() {
        return eventtime;
    }

    /**
     * @param eventtime
     */
    public void setEventtime(Date eventtime) {
        this.eventtime = eventtime;
    }

    /**
     * @return Message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}