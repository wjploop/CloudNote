package com.loop.controller;

import com.loop.entity.User;
import com.loop.service.UserService;
import com.loop.service.impl.NameException;
import com.loop.service.impl.PasswordException;
import com.loop.util.NoteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author  loop
 * create  2018-01-23 01:55.
 */


@Controller
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserService userService;


    @ResponseBody   //使用Json数据返回
    @RequestMapping("/login.do")
    public Object login(String name, String password) {

        return userService.login(name, password);
    }

}
