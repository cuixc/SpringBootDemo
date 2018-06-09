package com.example.demo.VO;

import java.io.Serializable;


public class UserVo implements Serializable {
	
	private static final long serialVersionUID = 8709103031218039212L;
	private Integer age;
	private String name;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserVo [age=" + age + ", name=" + name + "]";
	}
	
}
