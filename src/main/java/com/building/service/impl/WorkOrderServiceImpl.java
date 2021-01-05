package com.building.service.impl;

import com.building.dao.WorkOrderMapper;
import com.building.entity.WorkOrder;
import com.building.service.WorkOrderService;
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
public class WorkOrderServiceImpl implements WorkOrderService {

    @Autowired
    WorkOrderMapper orderMapper;

    @Override
    public List<WorkOrder> searchAllOrder() {
        return orderMapper.selectAll();
    }

    @Override
    public WorkOrder searchOrderById(String id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<WorkOrder> searchOrderByWhere(String param,String keyWord) {

        Example example = new Example(WorkOrder.class);
        Example.Criteria ec = example.createCriteria();

        if(StringUtils.isNotEmpty(keyWord)){
            ec.andEqualTo(param,keyWord);
        }

        return orderMapper.selectByExample(example);
    }

    @Override
    public Integer getOrderCount() {
        return orderMapper.getOrderCount();
    }

    @Override
    public void saveOrder(WorkOrder order) {
        orderMapper.insertSelective(order);
    }

    @Override
    public void updateOrder(WorkOrder order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public void deleteOrder(String id) {
        orderMapper.deleteByPrimaryKey(id);
    }
}
