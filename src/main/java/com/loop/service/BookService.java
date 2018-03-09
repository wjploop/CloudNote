package com.loop.service;

import com.loop.entity.Book;
import com.loop.util.NoteResult;

import java.util.List;

/**
 * author  loop
 * create  2018-02-01 09:31.
 */


public interface BookService {

    NoteResult<List<Book>> loadBooksByUserId(String userId);
}
