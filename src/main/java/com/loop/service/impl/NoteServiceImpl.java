package com.loop.service.impl;

import com.loop.dao.NoteDao;
import com.loop.dao.NotebookDao;
import com.loop.dao.UserDao;
import com.loop.entity.Note;
import com.loop.entity.Notebook;
import com.loop.entity.User;
import com.loop.service.NoteService;
import com.loop.service.exception.NoteNotFoundException;
import com.loop.service.exception.NotebookNotFoundException;
import com.loop.service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteDao noteDao;

    @Resource
    private UserDao userDao;

    @Resource
    private NotebookDao notebookDao;

    public List<Map<String, Object>>
    listNotes(String notebookId)
            throws NotebookNotFoundException {
        if (notebookId == null || notebookId.trim().isEmpty()) {
            throw new NotebookNotFoundException("Id空");
        }
        Notebook notebook = notebookDao
                .findNotebookById(notebookId);
        if (notebook == null) {
            throw new NotebookNotFoundException(
                    "笔记本不存在");
        }
        return noteDao.findNotesByNotebookId(notebookId);
    }

    public Note getNote(String noteId)
            throws NoteNotFoundException {
        if (noteId == null || noteId.trim().isEmpty()) {
            throw new NoteNotFoundException("ID空");
        }
        Note note = noteDao.findNoteById(noteId);
        if (note == null) {
            throw new NoteNotFoundException("id错误");
        }
        return note;
    }

    public boolean update(String noteId, String title, String body) throws NoteNotFoundException {
        if (noteId == null || noteId.trim().isEmpty()) {
            throw new NoteNotFoundException("ID不能空");
        }
        Note note = noteDao.findNoteById(noteId);
        if (note == null) {
            throw new NoteNotFoundException("没有对应的笔记");
        }
        Note data = new Note();
        if (title != null && !title.equals(note.getTitle())) {
            data.setTitle(title);
        }
        if (body != null && !body.equals(note.getBody())) {
            data.setBody(body);
        }
        data.setId(noteId);
        data.setTimeCreated(new Timestamp(System.currentTimeMillis()));
        System.out.println(data);
        int n = noteDao.updateNote(data);
        return n == 1;
    }

    public Note addNote(String userId,
                        String notebookId, String title)
            throws UserNotFoundException,
            NotebookNotFoundException {
        if (userId == null || userId.trim().isEmpty()) {
            throw new UserNotFoundException("ID空");
        }
        User user = userDao.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("木有人");
        }
        if (notebookId == null || notebookId.trim().isEmpty()) {
            throw new NotebookNotFoundException("ID空");
        }
        Notebook notebook = notebookDao.findNotebookById(notebookId);
        if (notebook == null) {
            throw new NotebookNotFoundException("没有笔记本");
        }
        if (title == null || title.trim().isEmpty()) {
            title = "葵花宝典";
        }
        String id = UUID.randomUUID().toString();
        String statusId = "note_status_id_1";
        String typeId = "note_type_id_1";
        String body = "";
        Timestamp time = new Timestamp(System.currentTimeMillis());
        Note note = new Note(id, notebookId,
                userId, statusId, typeId, false, title,
                body, time, time);
        int n = noteDao.addNote(note);
        if (n != 1) {
            throw new NoteNotFoundException("保存失败");
        }
        return note;
    }

    @Override
    public boolean moveNote(String noteId, String notebookId) {
        Note note = noteDao.findNoteById(noteId);
        note.setNotebookId(notebookId);
        note.setTimeLastModified(new Timestamp(System.currentTimeMillis()));
        int n=noteDao.updateNote(note);
        return n==1;
    }

    @Override
    public boolean removeNote(String noteId) {
        Note note = noteDao.findNoteById(noteId);
        if (note == null) {
            throw new NoteNotFoundException("Id空");
        }
        int n = noteDao.removeNote(note);
        return n==1;
    }

}







