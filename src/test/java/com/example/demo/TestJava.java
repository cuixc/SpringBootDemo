package com.example.demo;

import org.junit.Test;

import com.example.demo.entity.User;
import com.example.demo.mapper.MapperDao;

public class TestJava {
	@Test
	public  void test01() {
		User user = new User();
		user.setAge(22);
		user.setName("zhangsan");
		MapperDao<User> userMapper = new MapperDao<User>(user);
		try {
			System.out.println(userMapper.find(user));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
