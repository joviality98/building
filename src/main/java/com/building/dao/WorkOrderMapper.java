package com.building.dao;

import com.building.entity.WorkOrder;
import com.building.entity.vo.TotalVo;
import com.building.util.MyMapper;

import java.util.Date;
import java.util.List;

public interface WorkOrderMapper extends MyMapper<WorkOrder> {

    public Integer getOrderCount();


    List<WorkOrder> getNeedDeal();

    List<TotalVo> getTotalByYear(String year);

    List<TotalVo> getTotalByYearMonth(String year,String month);

    List<TotalVo> getTotalByUser(String id);

    List<TotalVo> getTotalByUserYear(String year,String id);

    List<TotalVo> getTotalByUserYearMonth(String year,String month,String id);

    List<TotalVo> getTotalByWeek(String week);

    List<WorkOrder> filterByDay(Date day);

    List<WorkOrder> filterByWeek();

    List<WorkOrder> filterByMonth();

    List<WorkOrder> filterByYear();

    List<WorkOrder> filterByLastYear();

    Integer countByDay();

    Integer countByWeek();

    Integer countByMonth();

    Integer countByYear();

    Integer countByLastYear();

    List<WorkOrder> filterByLastWeek();

    List<WorkOrder> filterByLastMonth();

    List<WorkOrder> filterByYearMonth();

    Integer countByLastWeek();

    Integer countByLastMonth();

    Integer countByYearMonth();
}