package com.building.service.impl;

import com.building.dao.AlarmEquipmentMapper;
import com.building.dao.AlarmLogMapper;
import com.building.entity.AlarmEquipment;
import com.building.entity.AlarmLog;
import com.building.service.AlarmEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmEquipmentServiceImpl implements AlarmEquipmentService {

    @Autowired
    private AlarmEquipmentMapper mapper;

    @Autowired
    private AlarmLogMapper alarmLogMapper;


    @Override
    public Integer alarmEquipTotal() {
        return mapper.getTotal();
    }

    @Override
    public List<AlarmEquipment> searchAll() {
        return mapper.selectAll();
    }

    @Override
    public void setAlarmEquipment(AlarmEquipment alarmEquipment) {
        mapper.updateByPrimaryKeySelective(alarmEquipment);
    }

    //    ---------------------------

    /**
     * 报警相关
     * @return
     */
    @Override
    public List<AlarmLog> alarmList() {
        return alarmLogMapper.selectAll();
    }

    @Override
    public Integer alarmTotal() {
        return alarmLogMapper.getTotal();
    }
    @Override
    public void addAlarm(AlarmLog alarmLog) {
        alarmLogMapper.insertSelective(alarmLog);
    }

    @Override
    public void editAlarm(AlarmLog alarmLog) {
        alarmLogMapper.updateByPrimaryKeySelective(alarmLog);
    }

    @Override
    public List<AlarmLog> searchAlarm(AlarmLog alarmLog) {
        return alarmLogMapper.select(alarmLog);
    }


}
