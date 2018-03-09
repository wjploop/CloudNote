package com.loop.service.impl;

import com.loop.dao.UserDao;
import com.loop.entity.User;
import com.loop.service.UserService;
import com.loop.util.NoteResult;
import com.loop.util.NoteUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author  loop
 * create  2018-01-22 21:06.
 */

@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;


    public NoteResult<User> login(String name, String password) {

        NoteResult<User> noteResult = new NoteResult<User>();
        //参数校验
        if (name == null || name.trim().isEmpty()) {
//            throw new NameException("用户名不能为空");
            noteResult.setMsg("用户名不能为空");
            noteResult.setState(1);
            return noteResult;

        }
        if (password == null || password.trim().isEmpty()) {
//            throw new PasswordException("密码不能为空");
            noteResult.setState(2);
            noteResult.setMsg("密码不能为空");
            return noteResult;
        }

        //调用Dao层，检查是否有该用户
        User user = userDao.findByName(name);

        if (user == null) {
//            throw new NameException("没有该用户");
            noteResult.setState(1);
            noteResult.setMsg("没有该用户");
            return noteResult;
        }
        String md5Password = NoteUtil.md5(password);

        if (!user.getPassword().equals(md5Password)) {
//            throw new PasswordException("密码错误");
            noteResult.setState(2);
            noteResult.setMsg("密码错误");
            return noteResult;
        }

        //成功
        noteResult.setState(0);
        noteResult.setData(user);
        noteResult.setMsg("success");
        return noteResult;
    }

    /**
     * 创建一个用户流程
     * 1.检验用户名是否可用
     * 2.插入用户
     *   1).生成id
     *   2).对密码加密
     * 返回消息
     * */
    @Override
    public NoteResult<Object> register(String username, String nickname, String password) {

        NoteResult<Object> result = new NoteResult<Object>();

        User hasUser = userDao.findByName(username);

        //检验用户名可用
        if (hasUser != null) {
            result.setState(1);
            result.setMsg("用户名已存在");
            return result;
        }
        User user = new User();
        user.setName(username);
        user.setNick(nickname);

        //密码加密
        user.setPassword(NoteUtil.md5(password));

        //生成id
        user.setId(NoteUtil.generateId());
        //插入User
        userDao.saveUser(user);

        result.setState(0);
        result.setMsg("注册成功");
        return result;
    }
}
