package com.qf.annotation;

import java.io.Serializable;

import com.qf.annotation.ValueBind.filedType;

/**
 * @Title: Student.java
 * @Package com.qf.annotation
 * @Description: 实体类
 * @author haichangzhang
 * @date 2017年7月26日 下午2:33:46
 * @version V1.0
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private int age;

	public String getId() {
		return id;
	}

	@ValueBind(type=filedType.String,value="1")
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	@ValueBind(type=filedType.String,value="zhangsan")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public int getAge() {
		return age;
	}
	@ValueBind(type=filedType.Int,value="30")
	public void setAge(int age) {
		this.age = age;
	}

}
