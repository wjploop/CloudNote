package com.loop.controller;

import com.loop.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * author  loop
 * create  2018-02-03 09:37.
 */


@Controller
@RequestMapping("/note")
public class NoteController {

    @Resource
    NoteService noteService;

    @ResponseBody
    @RequestMapping("/load_notes.do")
    public Object loadNotesByBookId(String bookId) {

        System.out.println("wolf:bookId=" + bookId);


        return noteService.loadNotesByBookId(bookId);
    }

    @ResponseBody
    @RequestMapping("/load_note.do")
    public Object loadNoteById(String noteId) {

        return noteService.loadNoteByNoteId(noteId);
    }
}
