package com.loop.controller;

import com.loop.service.UserService;
import com.loop.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * author  loop
 * create  2018-01-31 06:48.
 */


@Controller
@RequestMapping("/ user")
public class UserRegisterController {

    @Resource
    UserService userService;

    @ResponseBody
    @RequestMapping("/add.do")
    public NoteResult<Object> execute(String username, String nickname, String password) {
        return userService.register(username, nickname, password);
    }

}
