package com.building.config;

import com.building.dao.AlarmEquipmentMapper;
import com.building.dao.AlarmLogMapper;
import com.building.dao.UserMapper;
import com.building.dao.WorkOrderMapper;
import com.building.entity.AlarmEquipment;
import com.building.entity.AlarmLog;
import com.building.entity.User;
import com.building.entity.WorkOrder;
import com.building.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.*;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.PeriodicTrigger;
import tk.mybatis.mapper.entity.Example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

@Configuration //标记配置类
@EnableScheduling //开启定时任务
@EnableAsync //开启多线程
public class DynamicScheduleTask implements SchedulingConfigurer {

    private long orderTimer = ConstantUtils.Num.orderTimer;

    private long alarmTimer = ConstantUtils.Num.alarmTimer;

    @Autowired
    WorkOrderMapper workOrderMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    AlarmLogMapper alarmLogMapper;

    @Autowired
    AlarmEquipmentMapper alarmEquipmentMapper;

    public long getOrderTimer() {
        return orderTimer;
    }

    public void setOrderTimer(long orderTimer) {
        this.orderTimer = orderTimer;
    }

    public long getAlarmTimer() {
        return alarmTimer;
    }

    public void setAlarmTimer(long alarmTimer) {
        this.alarmTimer = alarmTimer;
    }

    //执行定时任务
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(
                //添加任务内容
                () -> {
                    System.out.println("执行定时任务");
                    List<WorkOrder> list = workOrderMapper.getNeedDeal();

                    list.forEach((order)->{
                        try {
                            goSend(order);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                },
                //设置执行周期（trigger）
                triggerContext -> {
                    //执行周期
                    //具体使用受制于cron表达式的规范，不能做到随心所欲设置循环间隔时间
//                    String cron = "0 0/30 * * * ?";
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);

                    //此处使用不同的触发器，为设置循环时间的关键，区别于CronTrigger触发器，
                    //该触发器可随意设置循环间隔时间，单位为毫秒
                    PeriodicTrigger periodicTrigger = new PeriodicTrigger(5*60*1000);
                    Date nextExecutionTime = periodicTrigger.nextExecutionTime(triggerContext);
                    return nextExecutionTime;
                }
        );

        taskRegistrar.addTriggerTask(
                //添加任务内容
                () -> {
                    connSqlServer();
                },
                //设置执行周期（trigger）
                triggerContext -> {
                    //执行周期
                    //具体使用受制于cron表达式的规范，不能做到随心所欲设置循环间隔时间
//                    String cron = "0 0/30 * * * ?";
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);

                    //此处使用不同的触发器，为设置循环时间的关键，区别于CronTrigger触发器，
                    //该触发器可随意设置循环间隔时间，单位为毫秒
                    PeriodicTrigger periodicTrigger = new PeriodicTrigger(alarmTimer);
                    Date nextExecutionTime = periodicTrigger.nextExecutionTime(triggerContext);
                    return nextExecutionTime;
                }
        );
    }

    @Async
    public void goSend(WorkOrder order) throws InterruptedException{
        List<User> list = userMapper.searchStaff("1","1");
        if(new Date().getTime()>order.getCreatedTime().getTime()+ orderTimer) {
            order.setWorkStatus(2);
            order.setDealId(list.get(0).getUserId());
            workOrderMapper.updateByPrimaryKeySelective(order);
        }
    }

    @Async
    public void connSqlServer() {
        //创建一个用于连接的对象
        Connection ct = null;
        //创建一个发送sql语句的对象
        PreparedStatement ps = null;
        PreparedStatement statement = null;
        //创建一个用于保存结果集的对象
        ResultSet rs = null;
        ResultSet set = null;
        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //得到连接
            ct = DriverManager.getConnection("jdbc:sqlserver://192.168.1.116\\SQLEXPRESS2017;DatabaseName=IcoUnifiedConfig", "sa", "123456");
            //进行crud操作
//            //增加操作
//            ps = ct.prepareStatement("insert into student(SNo,SName) values(?,?)");
//            ps.setString(1, "1513120188");
//            ps.setString(2, "阿三");
//            ps.executeUpdate();

//            //删除操作
//            ps = ct.prepareStatement("delete from student where SName = ?");
//            ps.setString(1, "刘猛");
//            ps.executeUpdate();

//            //修改操作
//            ps = ct.prepareStatement("update student set SNo = ? where SName = ?");
//            ps.setString(1, "1");
//            ps.setString(2, "马云");
//            ps.executeUpdate();

            //查询操作
            ps = ct.prepareStatement("select Severity,Area,ActiveTime,EventTime,Source,Message from AlarmLog where datediff(day,EventTime,getdate())=0");
            statement = ct.prepareStatement("select Name from AWX_Source");

            //收集结果集
            rs = ps.executeQuery();
            //循环输出
            while (rs.next()) {
                AlarmLog alarmLog = new AlarmLog();
                //报警等级
                Integer severity = rs.getInt(1);
                //区域
                String area = rs.getString(2);
                //本地时间
                Date active_time = rs.getTimestamp(3);
                //报警时间
                Date even_time = rs.getTimestamp(4);
                //名称
                String source = rs.getString(5);
                //信息
                String message = rs.getString(6);

                Example example = new Example(AlarmLog.class);
                example.createCriteria().andEqualTo("source",source);
                if(alarmLogMapper.selectByExample(example).isEmpty()){

                    alarmLog.setMessage(message);
                    alarmLog.setArea(area);
                    alarmLog.setEventtime(even_time);
                    alarmLog.setActivetime(active_time);
                    alarmLog.setSeverity(severity);
                    alarmLog.setSource(source);

                    System.out.println(alarmLog.toString());
                    alarmLogMapper.insertSelective(alarmLog);
                }
            }

            set = statement.executeQuery();

            while (set.next()){
                AlarmEquipment alarmEquipment = new AlarmEquipment();
                alarmEquipment.setAlarmId(set.getString(1));

                if(alarmEquipmentMapper.select(alarmEquipment).isEmpty()){
                    alarmEquipmentMapper.insertSelective(alarmEquipment);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (ct != null) {
                    ct.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }


}
