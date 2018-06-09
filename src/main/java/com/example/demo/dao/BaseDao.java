package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.example.demo.mapper.MapperDao;

public interface BaseDao<T> {
	@SelectProvider(type = MapperDao.class,method="find")
	List<T> find(T obj);
}
