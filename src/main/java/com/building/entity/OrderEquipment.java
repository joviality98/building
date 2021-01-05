package com.building.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "order_equipment")
public class OrderEquipment {
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "equip_id")
    private String equipId;

    private String img;

    /**
     * @return order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return equip_id
     */
    public String getEquipId() {
        return equipId;
    }

    /**
     * @param equipId
     */
    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    /**
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }
}