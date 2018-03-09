package com.loop.dao;

import com.loop.entity.Note;

import java.util.List;

/**
 * author  loop
 * create  2018-02-03 09:37.
 */


public interface NoteDao {

    List<Note> findNotesByBookId(String bookId);

    Note findNoteById(String noteId);
}
