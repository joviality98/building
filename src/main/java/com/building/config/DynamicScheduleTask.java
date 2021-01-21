package com.building.config;

import com.building.dao.UserMapper;
import com.building.dao.WorkOrderMapper;
import com.building.entity.User;
import com.building.entity.WorkOrder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Configuration //标记配置类
@EnableScheduling //开启定时任务
@EnableAsync //开启多线程
public class DynamicScheduleTask implements SchedulingConfigurer {

    @Autowired
    WorkOrderMapper workOrderMapper;

    @Autowired
    UserMapper userMapper;

    //执行定时任务
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        scheduledTaskRegistrar.addTriggerTask(
                //添加任务内容
                () -> {
                    System.out.println("执行定时任务:"+ LocalDateTime.now().toLocalTime());
                    List<WorkOrder> list = workOrderMapper.getNeedDeal();

                    System.out.println(list);
                    list.forEach((order)->{
                        System.out.println(order);
                        if(new Date().getTime()>order.getCreatedTime().getTime()+ 1000*60*60){
                            System.out.println("该派单了。。。。。。。");
//                            try {
//                                goSend(order);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                        }
                    });
                },
                //设置执行周期（trigger）
                triggerContext -> {
                    //执行周期
                    String cron = "0 5 * * * ?";
                    if(StringUtils.isEmpty(cron)){

                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

    @Async
    public void goSend(WorkOrder order) throws InterruptedException{
        List<User> list = userMapper.searchStaff("1","1");

            order.setWorkStatus(2);
            order.setDealId(list.get(0).getUserId());
            workOrderMapper.updateByPrimaryKeySelective(order);

            System.out.println(" =====完成派单 ======");
    }
}
