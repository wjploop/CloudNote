package dao;

import base.Base;
import com.loop.entity.Note;
import org.junit.Test;

import java.sql.Timestamp;

public class TestNoteDao extends Base{

    @Test
    public void testFindNotesByNotebookId() {
        System.out.println(noteDao.findNotesByNotebookId("book_id_1"));
    }

    @Test
    public void testFindNoteById() {
        System.out.println(noteDao.findNoteById("note_id_1"));
    }

    @Test
    public void testUpdateNote() {
        Note note = noteDao.findNoteById("note_id_1");
        note.setBody("hello,I have been updated from a stupid test method");
        System.out.println(noteDao.updateNote(note));
    }

    @Test
    public void testAddNote() {
        Note note = new Note("note_id_6", "book_id_1", "user_id_1", "note_status_id_1", "note_type_id_1", false,"python crawl", "python die", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        System.out.println(noteDao.addNote(note));
    }




}
