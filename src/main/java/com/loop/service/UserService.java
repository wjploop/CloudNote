package com.loop.service;


import com.loop.entity.User;
import com.loop.service.exception.NameException;
import com.loop.service.exception.PasswordException;

public interface UserService {
	/*
	 * 登录功能方法
	 * @param name 用户名
	 * @param password 密码
	 */
	User Login(String name, String password)
				throws NameException,PasswordException;

	User regist(String name, String password, String nick)
				throws NameException,PasswordException;
}







