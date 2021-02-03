package com.building.service;

import com.building.entity.AlarmEquipment;
import com.building.entity.AlarmLog;

import java.util.List;

public interface AlarmEquipmentService {

    //报警配置项
    Integer alarmEquipTotal();

    List<AlarmEquipment> searchAll();

    void setAlarmEquipment(AlarmEquipment alarmEquipment);

//    ------------------------
    //报警总数
    Integer alarmTotal();

    //报警列表
    List<AlarmLog> alarmList();

    //添加报警
    void addAlarm(AlarmLog alarmLog);

    //修改报警
    void editAlarm(AlarmLog alarmLog);

    //条件查找
    List<AlarmLog> searchAlarm(AlarmLog alarmLog);
}
