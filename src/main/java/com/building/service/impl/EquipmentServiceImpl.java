package com.building.service.impl;

import com.building.entity.Equipment;
import com.building.dao.EquipmentMapper;
import com.building.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CDSY
 * @since 2020-12-15
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> searchAllEquipment() {
        return equipmentMapper.selectAll();
    }

    @Override
    public Equipment searchEquipmentById(String id) {
        return equipmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Equipment> searchEquipmentByWhere(String param, String keyword) {
        Example example = new Example(Equipment.class);
        example.createCriteria().andEqualTo(param,keyword);
        return equipmentMapper.selectByExample(example);
    }

    @Override
    public Integer getEquipmentCount() {
        return equipmentMapper.getEquipmentCount();
    }

    @Override
    public void saveEquipment(Equipment work) {
        equipmentMapper.insertSelective(work);
    }

    @Override
    public void updateEquipment(Equipment work) {
        equipmentMapper.updateByPrimaryKeySelective(work);
    }

    @Override
    public void deleteEquipment(String id) {
        equipmentMapper.deleteByPrimaryKey(id);
    }
}
