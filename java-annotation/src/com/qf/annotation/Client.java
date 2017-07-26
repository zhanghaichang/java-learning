package com.qf.annotation;

import java.lang.reflect.Method;

/**
 * @Title: Client.java
 * @Package com.qf.annotation
 * @Description: TODO
 * @author haichangzhang
 * @date 2017年7月26日 上午10:47:56
 * @version V1.0
 */
@MyAnnotation1("Hello World!")
public class Client {

	@MyAnnotation2(description = "this is annotation2", isAnnotation = true)
	public static void sayHello() throws NoSuchMethodException, SecurityException {
		MyAnnotation2 annotation2 = Client.class.getMethod("sayHello", null).getAnnotation(MyAnnotation2.class);
		System.out.println(annotation2.description());
	}

	public static void main(String[] args) throws Exception {
		MyAnnotation1 annotation1 = Client.class.getAnnotation(MyAnnotation1.class);
		System.out.println(annotation1.value());
		sayHello();
		/* 利用JAVA类反射来实现我们的Annotation */
		Object object = Class.forName("com.qf.annotation.Student").newInstance();
		try {
			Method[] methods = object.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(ValueBind.class)) {
					ValueBind valueBind = method.getAnnotation(ValueBind.class);
					String type = String.valueOf(valueBind.type());
					String value = valueBind.value();
					if (type.equals("Int")) {
						method.invoke(object, new Integer[] { new Integer(value) });
					} else {
						method.invoke(object, new String[]{value});
					}
				}
			}
			Student student = (Student) object;
			System.out.println(student);
		} catch (Exception e) {
			 e.printStackTrace();
		}

	}

}
