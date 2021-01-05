package com.building.service;

import com.building.entity.OrderHistory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CDSY
 * @since 2020-12-15
 */
public interface OrderHistoryService{
    /**
     * 获取全部维修单
     * @return
     */
    List<OrderHistory> searchAllOrder();

    /**
     * 按照维修单号搜索维修单
     * @param id
     * @return
     */
    OrderHistory searchOrderById(String id);

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
    void saveOrder(OrderHistory work);

    /**
     * 更新维修单
     * @param work
     */
    void updateOrder(OrderHistory work);

    /**
     * 删除维修单
     * @param id
     */
    void deleteOrder(String id);

    /**
     * 按天获取工单
     * @return
     */
    List<OrderHistory> getHistoryByDay();

    Integer getCountByDay();

    /**
     * 按周获取工单
     * @return
     */
    List<OrderHistory> getHistoryByWeek();

    Integer getCountByWeek();

    /**
     * 按月获取工单
     * @return
     */
    List<OrderHistory> getHistoryByMonth();

    Integer getCountByMonth();

    /**
     * 按年获取工单
     * @return
     */
    List<OrderHistory> getHistoryByYear();

    Integer getCountByYear();

    /**
     * 按去年获取工单
     * @return
     */
    List<OrderHistory> getHistoryByLastYear();

    Integer getCountByLastYear();

    List<OrderHistory> getHistoryByLastWeek();

    List<OrderHistory> getHistoryByLastMonth();

    List<OrderHistory> getHistoryByYearMonth();

    Integer getCountByLastWeek();

    Integer getCountByLastMonth();

    Integer getCountByYearMonth();
}
