package com.qf.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**   
* @Title: MyAnnotation1.java 
* @Package com.qf.annotation 
* @Description: TODO
* @author haichangzhang   
* @date 2017年7月26日 上午10:32:03 
* @version V1.0   
*/

@Target(ElementType.TYPE)//类、接口或enum声明
@Retention(RetentionPolicy.RUNTIME)// VM将在运行时也保存注解(如果需要通过反射读取注解，则使用该值)。
@Documented//将此注解包含在Javadoc中。
public @interface MyAnnotation1 {
	
	String value();

}
