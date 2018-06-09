package com.example.demo.manger.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.manger.UserMng;

@Service
public class UserMngImpl implements UserMng{
	@Override
	public List<User> findByUser(User user) {
		//redisCache.get(key)
		return null;
	}

}
