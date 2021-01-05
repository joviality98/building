package com.building.service.impl;

import com.building.dao.OrderHistoryMapper;
import com.building.entity.OrderHistory;
import com.building.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    OrderHistoryMapper orderHistoryMapper;


    @Override
    public List<OrderHistory> searchAllOrder() {
        return orderHistoryMapper.selectAll();
    }

    @Override
    public OrderHistory searchOrderById(String id) {
        return orderHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getOrderCount() {
        return orderHistoryMapper.getAllCount();
    }

    @Override
    public void saveOrder(OrderHistory work) {
        orderHistoryMapper.insertSelective(work);
    }

    @Override
    public void updateOrder(OrderHistory work) {
        orderHistoryMapper.updateByPrimaryKeySelective(work);
    }

    @Override
    public void deleteOrder(String id) {
        orderHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<OrderHistory> getHistoryByDay() {
        return orderHistoryMapper.filterByDay();
    }

    @Override
    public Integer getCountByDay() {
        return orderHistoryMapper.countByDay();
    }

    @Override
    public List<OrderHistory> getHistoryByWeek() {
        return orderHistoryMapper.filterByWeek();
    }

    @Override
    public Integer getCountByWeek() {
        return orderHistoryMapper.countByWeek();
    }

    @Override
    public List<OrderHistory> getHistoryByMonth() {
        return orderHistoryMapper.filterByMonth();
    }

    @Override
    public Integer getCountByMonth() {
        return orderHistoryMapper.countByMonth();
    }

    @Override
    public List<OrderHistory> getHistoryByYear() {
        return orderHistoryMapper.filterByYear();
    }

    @Override
    public Integer getCountByYear() {
        return orderHistoryMapper.countByYear();
    }

    @Override
    public List<OrderHistory> getHistoryByLastYear() {
        return orderHistoryMapper.filterByLastYear();
    }

    @Override
    public Integer getCountByLastYear() {
        return orderHistoryMapper.countByLastYear();
    }

    @Override
    public List<OrderHistory> getHistoryByLastWeek() {
        return orderHistoryMapper.filterByLastWeek();
    }

    @Override
    public List<OrderHistory> getHistoryByLastMonth() {
        return orderHistoryMapper.filterByLastMonth();
    }

    @Override
    public List<OrderHistory> getHistoryByYearMonth() {
        return orderHistoryMapper.filterByYearMonth();
    }

    @Override
    public Integer getCountByLastWeek() {
        return orderHistoryMapper.countByLastWeek();
    }

    @Override
    public Integer getCountByLastMonth() {
        return orderHistoryMapper.countByLastMonth();
    }

    @Override
    public Integer getCountByYearMonth() {
        return orderHistoryMapper.countByYearMonth();
    }
}
