package com.example.demo.DTO;

import java.io.Serializable;


public class UserVo implements Serializable {
	
	private static final long serialVersionUID = 8709103031218039212L;
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "UserVo [age=" + age + ", name=" + name + "]";
	}
	
}
