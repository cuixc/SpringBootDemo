package com.example.demo.manger;

import java.util.List;

import com.example.demo.entity.User;

public interface UserMng {
	List<User> findByUser(User user);
}
