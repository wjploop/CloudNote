package com.loop.service.impl;

import com.loop.dao.UserDao;
import com.loop.entity.User;
import com.loop.service.UserService;
import com.loop.service.exception.NameException;
import com.loop.service.exception.PasswordException;
import com.loop.util.NoteUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	public User Login(String name, String password) throws NameException, PasswordException {
		//参数校验
		if(name==null||name.trim().isEmpty()){
			throw new NameException("用户名不能空");
		}
		if(password==null || password.trim().isEmpty()){
			throw new PasswordException("密码不能空");
		}
		//调用Dao,根据用户名查找用户
		User user
			=userDao.findByName(name);
		//判断结果,比对密码
		if(user==null){
			throw new NameException("用户名错误");
		}
		//对请求传过来的密码数据加密
		String md5Password= NoteUtil.md5(password);
		
		if(user.getPassword().equals(md5Password)){
			return user;
		}else{
			throw new PasswordException("密码错误");
		}
	}
	public User regist(String name, String password, String nick) 
			throws NameException, PasswordException {
		//判断用户是否被占用
		User user=userDao.findByName(name);
		if(user!=null){
			throw new NameException("已注册");
		}
		//检测格式
		if(name==null||name.trim().isEmpty()){
			throw new NameException("用户名为空");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码为空");
		}
		if(nick==null||nick.trim().isEmpty()){
			nick=name;
		}
		//生成ID
		String id=NoteUtil.createId();
		//密码加密
		password=NoteUtil.md5(password);
		String token="";
		user=new User(id,name,password,token,nick);
		//调用Dao
		userDao.addUser(user);
		
		return user;
	}

}






