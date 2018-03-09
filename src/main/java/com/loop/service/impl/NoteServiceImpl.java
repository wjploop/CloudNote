package com.loop.service.impl;

import com.loop.dao.NoteDao;
import com.loop.entity.Note;
import com.loop.service.NoteService;
import com.loop.util.NoteResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * author  loop
 * create  2018-02-03 12:10.
 */


@Service("noteService")
public class NoteServiceImpl implements NoteService{

    @Resource
    NoteDao noteDao;

    @Override
    public NoteResult<List<Note>> loadNotesByBookId(String bookId) {

        NoteResult<List<Note>> result = new NoteResult<List<Note>>();

        List<Note> noteList = new ArrayList<Note>();
        noteList = noteDao.findNotesByBookId(bookId);

        if (noteList.size() == 0) {
            result.setState(1);
            result.setMsg("该笔记本没有笔记");
            return result;
        }
        result.setState(0);
        result.setData(noteList);
        result.setMsg("该笔记本共有" + noteList.size() + "本笔记");
        return result;


    }

    @Override
    public NoteResult<Note> loadNoteByNoteId(String noteId) {

        NoteResult result = new NoteResult();

        Note note = noteDao.findNoteById(noteId);
        if (note == null) {
            result.setState(1);
            result.setMsg("未找到数据");
            return result;
        }else{
            result.setState(0);
            result.setData(note);
            result.setMsg("success");
            return result;
        }
    }
}
