package dao;

import base.Base;
import com.loop.entity.Notebook;
import org.junit.Test;

import java.sql.Timestamp;

public class TestNotebookDao extends Base {

    @Test
    public void testFindNotesByUserId() {
        System.out.println(notebookDao.findNotebookByUserId("user_id_1"));
    }

    @Test
    public void testFindNoteByBookId() {

        System.out.println(notebookDao.findNotebookById("book_id_1"));
    }

    @Test
    public void testAddNotebook() {
        Notebook notebook = new Notebook("note_book_id_4", "桃花源", "book_type_id_1", "user_id_1", "hello ", new Timestamp(System.currentTimeMillis()));
        notebookDao.addNotebook(notebook);
    }
}
