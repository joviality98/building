package com.building.service;

import com.building.entity.WorkOrder;

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
     * 按照条件搜索维修单
     * @param id
     * @return
     */
    List<WorkOrder> searchOrderByWhere(String param,String id);

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
}
