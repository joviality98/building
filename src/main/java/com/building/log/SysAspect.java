package com.building.log;


import com.building.entity.SysLog;
import com.building.entity.User;
import com.building.service.SysLogService;
import com.building.util.JwtUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
public class SysAspect {

    @Resource
    private SysLogService sysLogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.building.log.MyLog)")
    public void logPointCut(){
    }

    @AfterReturning("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        //保存日志
        SysLog sysLog = new SysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog operation = method.getAnnotation(MyLog.class);
        if (operation != null) {
            String value = operation.value();
            sysLog.setDescs(value);//保存获取的操作
        }

        //获取请求的类名methods
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = signature.getName();
        sysLog.setMethods(className + "." + methodName);

        // 获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取userName
        String token = request.getHeader( "Authorization");
        User user = JwtUtil.getUser(token);
        String userName = user.getUserName();
        sysLog.setUserName(userName);

        //设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));

        //获取请求时间
        sysLog.setCreateTime(new Date());

        //调用service保存SysLog实体类到数据库
        sysLogService.saveSysLog(sysLog);
    }
}

