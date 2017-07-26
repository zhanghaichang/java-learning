package com.qf.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: MyAnnotation2.java
 * @Package com.qf.annotation
 * @Description: TODO
 * @author haichangzhang
 * @date 2017年7月26日 上午10:48:28
 * @version V1.0
 */
@Target(ElementType.METHOD)//方法声明
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation2 {
	String description();

	boolean isAnnotation();
}
