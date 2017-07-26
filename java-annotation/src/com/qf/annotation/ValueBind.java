package com.qf.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**   
* @Title: ValueBind.java 
* @Package com.qf.annotation 
* @Description: annotation只能被标注在方法上
* @author haichangzhang   
* @date 2017年7月26日 下午2:34:47 
* @version V1.0   
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValueBind {
	
	enum filedType{
		String,Int
	};
	
	filedType type();
	String value();

}
