package com.example.demo.mapper;

import java.lang.reflect.Field;
import java.util.List;

public class MapperDao<T> {
	private T obj;
	public MapperDao(T entity) {
		this.obj = entity;
	}
	public String find(T obj) throws IllegalArgumentException, IllegalAccessException{
		String sql = "select * from "+obj.getClass().getName();
		int flag = 0;//是否为第一个条件
		Class tClass = obj.getClass();
		Field[] fields = tClass.getDeclaredFields();
		for (Field field : fields) {
			String val = (String) field.get(obj);
			if(!val.isEmpty()) {
				String name = field.getName();
				if(flag != 0) sql += " and ";
				sql += name +"='"+val+"'";
				flag++;
			}
		}
		return sql;
	};
	
}
