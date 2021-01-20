package com.building.log;

import java.lang.annotation.*;

/**
 * 自定义注解类
 **/
@Target(ElementType.METHOD)//注解防止的目标位置，METHOD时刻注解在方法级别上
@Retention(RetentionPolicy.RUNTIME)//注解在那个阶段执行
@Inherited
@Documented//生成文档
public @interface MyLog {
    String value() default "";
}
