package com.loop.controller;

import com.loop.entity.User;
import com.loop.service.UserService;
import com.loop.service.exception.NameException;
import com.loop.service.exception.PasswordException;
import com.loop.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login.do")
    public Object login(String name, String password) {
        User user
                = userService.Login(name, password);
        return new JsonResult(user);
    }

    //用户注册
    @RequestMapping("/register.do")
    @ResponseBody
    public JsonResult register(String name, String password,
                               String nick) {
        User user
                = userService.regist(name, password, nick);
        return new JsonResult(user);
    }

    @ExceptionHandler(NameException.class)
    @ResponseBody
    public JsonResult handleNameExp(NameException e) {
//		e.printStackTrace();
        return new JsonResult(2, e);
    }

    @ExceptionHandler(PasswordException.class)
    @ResponseBody
    public JsonResult handlePwdExp(PasswordException e) {
//		e.printStackTrace();
        return new JsonResult(3, e);
    }


}






