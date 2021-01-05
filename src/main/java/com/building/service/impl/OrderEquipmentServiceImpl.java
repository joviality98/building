package com.building.service.impl;

import com.building.dao.OrderEquipmentMapper;
import com.building.entity.OrderEquipment;
import com.building.service.OrderEquipmentService;
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
public class OrderEquipmentServiceImpl implements OrderEquipmentService {

    @Autowired
    private OrderEquipmentMapper mapper;


    @Override
    public List<OrderEquipment> searchAll(String  orderId,String equipmentId) {
        Example example = new Example(OrderEquipment.class);
        example.createCriteria().andEqualTo("orderId",orderId).andEqualTo("equipId",equipmentId);
        return mapper.selectByExample(example);
    }

    @Override
    public void saveEquipImg(OrderEquipment order) {
        mapper.insertSelective(order);
    }

    @Override
    public void updateEquipImg(OrderEquipment order) {
        mapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public void deleteEquipImg(OrderEquipment order) {
        mapper.delete(order);
    }
}
