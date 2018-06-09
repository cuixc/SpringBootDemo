package com.example.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.User;

public interface UserService extends IService<User> {
	List<User> findAll();
}
