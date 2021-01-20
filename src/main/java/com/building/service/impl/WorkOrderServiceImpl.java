package com.building.service.impl;

import com.building.dao.UserMapper;
import com.building.dao.WorkOrderMapper;
import com.building.entity.User;
import com.building.entity.WorkOrder;
import com.building.entity.vo.TotalVo;
import com.building.service.WorkOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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

    @Autowired
    UserMapper userMapper;

    @Override
    public List<WorkOrder> searchAllOrder() {
        return orderMapper.selectAll();
    }

    @Override
    public WorkOrder searchOrderById(String id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<WorkOrder> searchOrderByWhere(String param,String keyWord,String start,String end) {

        Example example = new Example(WorkOrder.class);
        Example.Criteria ec = example.createCriteria();

        if(StringUtils.isNotEmpty(keyWord)){
            ec.andEqualTo(param,keyWord);
        }
        if(StringUtils.isNoneBlank(start)){
            ec.andGreaterThanOrEqualTo("createdTime",start);
        }
        if(StringUtils.isNoneBlank(end)){
            ec.andLessThanOrEqualTo("createdTime",end);
        }
        example.setOrderByClause("created_time desc");

        return orderMapper.selectByExample(example);
    }

    @Override
    public List<WorkOrder> searchOrderByWhere(String param, String keyWord) {
        Example example = new Example(WorkOrder.class);
        Example.Criteria ec = example.createCriteria();

        if(StringUtils.isNotEmpty(keyWord)){
            ec.andEqualTo(param,keyWord);
        }

        return orderMapper.selectByExample(example);
    }

    @Override
    public Integer countByWhere(String param, String keyWord, String start, String end) {
        Example example = new Example(WorkOrder.class);
        Example.Criteria ec = example.createCriteria();

        if(StringUtils.isNotEmpty(keyWord)){
            ec.andEqualTo(param,keyWord);
        }
        if(StringUtils.isNoneBlank(start)){
            ec.andGreaterThanOrEqualTo("createdTime",start);
        }
        if(StringUtils.isNoneBlank(end)){
            ec.andLessThanOrEqualTo("createdTime",end);
        }
        example.setOrderByClause("created_time desc");

        return orderMapper.selectCountByExample(example);
    }

    @Override
    public Integer countByWhere(String param, String keyWord) {
        Example example = new Example(WorkOrder.class);
        Example.Criteria ec = example.createCriteria();

        if(StringUtils.isNotEmpty(keyWord)){
            ec.andEqualTo(param,keyWord);
        }

        return orderMapper.selectCountByExample(example);
    }

    @Override
    public List<WorkOrder> searchOrderByUserAndStatus(String id, String status) {
        Example example = new Example(WorkOrder.class);
        Example.Criteria ec = example.createCriteria();
        ec.andEqualTo("dealId",id).andEqualTo("workStatus",status);

        return orderMapper.selectByExample(example);
    }

    @Override
    public Integer countByUserAndStatus(String id, String status) {
        Example example = new Example(WorkOrder.class);
        Example.Criteria ec = example.createCriteria();
        ec.andEqualTo("dealId",id).andEqualTo("workStatus",status);

        return orderMapper.selectCountByExample(example);
    }

    @Override
    public Integer getOrderCount() {
        return orderMapper.getOrderCount();
    }

    @Override
    public void saveOrder(WorkOrder order) {
        orderMapper.insertSelective(order);
        //测试定时器，30分钟后自动派单，改变工单状态
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    WorkOrder workOrder = orderMapper.selectByPrimaryKey(order);
                    List<User> list = userMapper.searchStaff("1","1");
                    if(workOrder.getWorkStatus() == 1){
                        workOrder.setDealId(list.get(0).getUserId());
                        workOrder.setWorkStatus(2);
                        orderMapper.updateByPrimaryKeySelective(workOrder);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },1800000);
    }

    @Override
    public void updateOrder(WorkOrder order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public void deleteOrder(String id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TotalVo> getTotal(String year) {
        return orderMapper.getTotalByYear(year);
    }

    @Override
    public List<TotalVo> getTotal(String year, String month) {
        return orderMapper.getTotalByYearMonth(year,month);
    }

    @Override
    public List<TotalVo> getTotalbyUser(String id) {
        return orderMapper.getTotalByUser(id);
    }

    @Override
    public List<TotalVo> getTotalbyUser(String year, String id) {
        return orderMapper.getTotalByUserYear(year,id);
    }

    @Override
    public List<TotalVo> getTotalbyUser(String year, String month, String id) {
        return orderMapper.getTotalByUserYearMonth(year,month,id);
    }

    @Override
    public List<TotalVo> getTotalByWeek(String week) {
        return orderMapper.getTotalByWeek(week);
    }

    @Override
    public List<WorkOrder> getHistoryByDay(Date day) {
        return orderMapper.filterByDay(day);
    }

    @Override
    public Integer getCountByDay() {
        return orderMapper.countByDay();
    }

    @Override
    public List<WorkOrder> getHistoryByWeek() {
        return orderMapper.filterByWeek();
    }

    @Override
    public Integer getCountByWeek() {
        return orderMapper.countByWeek();
    }

    @Override
    public List<WorkOrder> getHistoryByMonth() {
        return orderMapper.filterByMonth();
    }

    @Override
    public Integer getCountByMonth() {
        return orderMapper.countByMonth();
    }

    @Override
    public List<WorkOrder> getHistoryByYear() {
        return orderMapper.filterByYear();
    }

    @Override
    public Integer getCountByYear() {
        return orderMapper.countByYear();
    }

    @Override
    public List<WorkOrder> getHistoryByLastYear() {
        return orderMapper.filterByLastYear();
    }

    @Override
    public Integer getCountByLastYear() {
        return orderMapper.countByLastYear();
    }

    @Override
    public List<WorkOrder> getHistoryByLastWeek() {
        return orderMapper.filterByLastWeek();
    }

    @Override
    public List<WorkOrder> getHistoryByLastMonth() {
        return orderMapper.filterByLastMonth();
    }

    @Override
    public List<WorkOrder> getHistoryByYearMonth() {
        return orderMapper.filterByYearMonth();
    }

    @Override
    public Integer getCountByLastWeek() {
        return orderMapper.countByLastWeek();
    }

    @Override
    public Integer getCountByLastMonth() {
        return orderMapper.countByLastMonth();
    }

    @Override
    public Integer getCountByYearMonth() {
        return orderMapper.countByYearMonth();
    }
}
