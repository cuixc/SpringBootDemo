package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.User;

@Component
public interface UserDao extends BaseMapper<User> {
	
	List<User> findAllBySelectSQL();

	//======================================================

	@Select("select * from user")
	List<User> findAll();
}
