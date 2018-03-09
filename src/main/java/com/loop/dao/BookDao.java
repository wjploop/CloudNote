package com.loop.dao;

import com.loop.entity.Book;

import java.util.List;

/**
 * author  loop
 * create  2018-02-01 09:11.
 */


public interface BookDao {

    List<Book> findBooksByUserId(String userId);
}
