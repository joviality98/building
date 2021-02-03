package com.building.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "alarm_equipment")
public class AlarmEquipment {
    @Id
    private Long id;

    @Column(name = "equipment_id")
    private String equipmentId;

    @Column(name = "alarm_id")
    private String alarmId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * @return alarm_id
     */
    public String getAlarmId() {
        return alarmId;
    }

    /**
     * @param alarmId
     */
    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }
}