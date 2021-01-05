package com.building.dao;

import com.building.entity.OrderHistory;
import com.building.util.MyMapper;

import java.util.List;

public interface OrderHistoryMapper extends MyMapper<OrderHistory> {
    Integer getAllCount();

    List<OrderHistory> filterByDay();

    List<OrderHistory> filterByWeek();

    List<OrderHistory> filterByMonth();

    List<OrderHistory> filterByYear();

    List<OrderHistory> filterByLastYear();

    Integer countByDay();

    Integer countByWeek();

    Integer countByMonth();

    Integer countByYear();

    Integer countByLastYear();

    List<OrderHistory> filterByLastWeek();

    List<OrderHistory> filterByLastMonth();

    List<OrderHistory> filterByYearMonth();

    Integer countByLastWeek();

    Integer countByLastMonth();

    Integer countByYearMonth();


}