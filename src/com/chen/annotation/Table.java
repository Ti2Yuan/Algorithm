package com.chen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Target({ElementType.TYPE})   //注解的使用范围  此处为类
//注解的生命周期  主要有3种:源代码（class文件不存在），编译期（class文件存在），运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

	String value();
}
