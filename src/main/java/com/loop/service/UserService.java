package com.loop.service;

import com.loop.entity.User;
import com.loop.util.NoteResult;

/**
 * author  loop
 * create  2018-01-22 21:03.
 */


public interface UserService {

    NoteResult<User> login(String name, String password);

    /**
     * 检查用户是否已经存在
     * user=findByName()
     * if user!=null
     * result
     * 添加用户
     * createID
     * 处理password,使用md5加密
     * user.set()
     * save(user)
     * <p>
     * 设置result
     */

    NoteResult<Object> register(String username, String nickname, String password);

}
