package com.building.service;

import com.building.entity.Equipment;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CDSY
 * @since 2020-12-15
 */
public interface EquipmentService{
    /**
     * 获取全部维修单
     * @return
     */
    List<Equipment> searchAllEquipment();

    /**
     * 按照维修单号搜索维修单
     * @param id
     * @return
     */
    Equipment searchEquipmentById(String id);

    /**
     * 按照条件搜索维修单
     * @param
     * @return
     */
    List<Equipment> searchEquipmentByWhere(Equipment equipment);

    /**
     * 获得工单总数量
     * @return
     */
    Integer getEquipmentCount();

    /**
     * 获得工单总数量
     * @return
     */
    Integer getSearchCount(Equipment e);

    /**
     * 添加维修单
     * @param work
     *
     */
    void saveEquipment(Equipment work);

    /**
     * 更新维修单
     * @param work
     */
    void updateEquipment(Equipment work);

    /**
     * 删除维修单
     * @param id
     */
    void deleteEquipment(String id);
}
