package com.loop.service;

import com.loop.entity.Note;
import com.loop.util.NoteResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  loop
 * create  2018-02-03 09:41.
 */


public interface NoteService {

    NoteResult<List<Note>> loadNotesByBookId(String bookId);

    NoteResult<Note> loadNoteByNoteId(String noteId);




}
