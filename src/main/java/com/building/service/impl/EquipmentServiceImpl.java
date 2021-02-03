package com.building.service.impl;

import com.building.entity.Equipment;
import com.building.dao.EquipmentMapper;
import com.building.service.EquipmentService;
import org.apache.commons.lang3.StringUtils;
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
    public List<Equipment> searchEquipmentByWhere(Equipment e) {
        Example example = new Example(Equipment.class);
        Example.Criteria ec = example.createCriteria();

        if(StringUtils.isNotBlank(e.getEquipmentId())){
            ec.andEqualTo("equipmentId",e.getEquipmentId());
        }
        if(StringUtils.isNotBlank(e.getEquipmentName())){
            ec.andEqualTo("equipmentName",e.getEquipmentName());
        }
        if(StringUtils.isNotBlank(e.getChanxian())){
            ec.andEqualTo("chanxian",e.getChanxian());
        }
        if(StringUtils.isNotBlank(e.getChejian())){
            ec.andEqualTo("chejian",e.getChejian());
        }
        if(StringUtils.isNotBlank(e.getModel())){
            ec.andEqualTo("model",e.getModel());
        }
        if(StringUtils.isNotBlank(e.getBrand())){
            ec.andEqualTo("brand",e.getBrand());
        }
        if(StringUtils.isNotBlank(e.getDeptName())){
            ec.andEqualTo("deptName",e.getDeptName());
        }
        if(StringUtils.isNotBlank(e.getKindName())){
            ec.andEqualTo("kindName",e.getKindName());
        }
        if(StringUtils.isNotBlank(e.getEquipmentStatus().toString())){
            ec.andEqualTo("equipmentStatus",e.getEquipmentStatus());
        }
        if(StringUtils.isNotBlank(e.getPosition())){
            ec.andEqualTo("position",e.getPosition());
        }
        if(StringUtils.isNotBlank(e.getUseTo())){
            ec.andEqualTo("useTo",e.getUseTo());
        }
        if(StringUtils.isNotBlank(e.getSourse())){
            ec.andEqualTo("source",e.getSourse());
        }

        return equipmentMapper.selectByExample(example);
    }

    @Override
    public Integer getEquipmentCount() {
        return equipmentMapper.getTotal();
    }

    @Override
    public Integer getSearchCount(Equipment e) {
        Example example = new Example(Equipment.class);
        Example.Criteria ec = example.createCriteria();

        if(StringUtils.isNotBlank(e.getEquipmentId())){
            ec.andEqualTo("equipmentId",e.getEquipmentId());
        }
        if(StringUtils.isNotBlank(e.getEquipmentName())){
            ec.andEqualTo("equipmentName",e.getEquipmentName());
        }
        if(StringUtils.isNotBlank(e.getChanxian())){
            ec.andEqualTo("chanxian",e.getChanxian());
        }
        if(StringUtils.isNotBlank(e.getChejian())){
            ec.andEqualTo("chejian",e.getChejian());
        }
        if(StringUtils.isNotBlank(e.getModel())){
            ec.andEqualTo("model",e.getModel());
        }
        if(StringUtils.isNotBlank(e.getBrand())){
            ec.andEqualTo("brand",e.getBrand());
        }
        if(StringUtils.isNotBlank(e.getDeptName())){
            ec.andEqualTo("deptName",e.getDeptName());
        }
        if(StringUtils.isNotBlank(e.getKindName())){
            ec.andEqualTo("kindName",e.getKindName());
        }
        if(StringUtils.isNotBlank(e.getEquipmentStatus().toString())){
            ec.andEqualTo("equipmentStatus",e.getEquipmentStatus());
        }
        if(StringUtils.isNotBlank(e.getPosition())){
            ec.andEqualTo("position",e.getPosition());
        }
        if(StringUtils.isNotBlank(e.getUseTo())){
            ec.andEqualTo("useTo",e.getUseTo());
        }
        if(StringUtils.isNotBlank(e.getSourse())){
            ec.andEqualTo("source",e.getSourse());
        }

        return equipmentMapper.selectCountByExample(example);
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
