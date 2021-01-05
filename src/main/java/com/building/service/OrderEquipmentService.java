package com.building.service;

import com.building.entity.OrderEquipment;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CDSY
 * @since 2020-12-15
 */
public interface OrderEquipmentService {
    /**
     * 获取某个工单对应的全部设备图片
     * @return
     */
    List<OrderEquipment> searchAll(String  orderId,String equipmentId);

    /**
     * 添加设备图片
     * @param order
     *
     */
    void saveEquipImg(OrderEquipment order);

    /**
     * 更新设备图片
     * @param order
     */
    void updateEquipImg(OrderEquipment order);

    /**
     * 删除设备图片
     * @param order
     */
    void deleteEquipImg(OrderEquipment order);
}
