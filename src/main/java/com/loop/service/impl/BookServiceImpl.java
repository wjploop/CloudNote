package com.loop.service.impl;

import com.loop.dao.BookDao;
import com.loop.entity.Book;
import com.loop.service.BookService;
import com.loop.util.NoteResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * author  loop
 * create  2018-02-01 09:34.
 */

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    @Override
    public NoteResult<List<Book>> loadBooksByUserId(String userId) {

        NoteResult<List<Book>> result = new NoteResult<List<Book>>();

        List<Book> bookList = new ArrayList<Book>();

        bookList=bookDao.findBooksByUserId(userId);

        if (bookList.isEmpty()) {
            result.setState(1);
            result.setMsg("没有查询到笔记本");
            return result;
        }
        result.setState(0);
        result.setData(bookList);
        result.setMsg("查询到笔记本个数为:" + bookList.size());
        return result;
    }
}
