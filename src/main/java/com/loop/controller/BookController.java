package com.loop.controller;

import com.loop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * author  loop
 * create  2018-02-01 09:28.
 */

@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    BookService bookService;

    @ResponseBody
    @RequestMapping("/load.do")
    public Object loadBooksByUserId(String userId)
    {
        return bookService.loadBooksByUserId(userId);
    }


}
