package com.building.service;

import com.building.entity.WorkOrder;
import com.building.entity.vo.TotalVo;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CDSY
 * @since 2020-12-15
 */
public interface WorkOrderService {
    /**
     * 获取全部维修单
     * @return
     */
    List<WorkOrder> searchAllOrder();

    /**
     * 按照维修单号搜索维修单
     * @param id
     * @return
     */
    WorkOrder searchOrderById(String id);

    /**
     * 按照条件搜索维修单 --- 单条件查询
     * @param param 查找条件的字段名
     * @param key 字段名对应的值
     * @return
     */
    List<WorkOrder> searchOrderByWhere(String param,String key, String start,String end);

    List<WorkOrder> searchOrderByWhere(String param,String key);

    Integer countByWhere(String param,String key, String start,String end);

    Integer countByWhere(String param,String key);

    //多条件查询
    List<WorkOrder> searchOrderByUserAndStatus(String id,String status);

    Integer countByUserAndStatus(String id,String status);
    /**
     * 获得工单总数量
     * @return
     */
    Integer getOrderCount();

    /**
     * 添加维修单
     * @param work
     *
     */
    void saveOrder(WorkOrder work);

    /**
     * 更新维修单
     * @param work
     */
    void updateOrder(WorkOrder work);

    /**
     * 删除维修单
     * @param id
     */
    void deleteOrder(String id);

    //查询某年每月的数据总量
    List<TotalVo> getTotal(String year);

    //查询某年某月每天的数据总量
    List<TotalVo> getTotal(String year,String month);

    //查询某人某年每月的数据总量
    List<TotalVo> getTotalbyUser(String id);

    //查询某人某年每月的数据总量
    List<TotalVo> getTotalbyUser(String year,String id);

    //查询某人某年某月每天的数据总量
    List<TotalVo> getTotalbyUser(String year,String month,String id);

    //查询一周的数据总量
    List<TotalVo> getTotalByWeek(String week);
<<<<<<< HEAD
    /**
     * 按天获取工单
     * @return
     */
    List<WorkOrder> getHistoryByDay(Date date);

    Integer getCountByDay();

    /**
     * 按周获取工单
     * @return
     */
    List<WorkOrder> getHistoryByWeek();

    Integer getCountByWeek();

    /**
     * 按月获取工单
     * @return
     */
    List<WorkOrder> getHistoryByMonth();

    Integer getCountByMonth();

    /**
     * 按年获取工单
     * @return
     */
    List<WorkOrder> getHistoryByYear();

    Integer getCountByYear();

    /**
     * 按去年获取工单
     * @return
     */
    List<WorkOrder> getHistoryByLastYear();

    Integer getCountByLastYear();

    List<WorkOrder> getHistoryByLastWeek();

    List<WorkOrder> getHistoryByLastMonth();

    List<WorkOrder> getHistoryByYearMonth();

    Integer getCountByLastWeek();

    Integer getCountByLastMonth();

    Integer getCountByYearMonth();
=======

>>>>>>> bbea5954caac95170547b5904d7a19d856c5757a
}
