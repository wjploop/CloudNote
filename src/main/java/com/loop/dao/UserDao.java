package com.loop.dao;


import com.loop.entity.User;

public interface UserDao {
	User findByName(String name);
	
	void addUser(User user);
	
	User findUserById(String userId);
}
