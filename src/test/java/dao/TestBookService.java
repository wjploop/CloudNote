package dao;

import com.loop.entity.Book;
import com.loop.entity.Note;
import com.loop.service.BookService;
import com.loop.service.NoteService;
import com.loop.service.UserService;
import com.loop.util.NoteResult;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * author  loop
 * create  2018-02-01 09:43.
 */


public class TestBookService {

    BookService bookService;

    NoteService noteService;

    @Before
    public void init() {
        String[] conf = {"conf/spring-mvc.xml", "conf/spring-mybatis.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(conf);

        bookService = context.getBean("bookService", BookService.class);
        noteService = context.getBean("noteService", NoteService.class);

    }

    @Test
    public void testFindBooksByUserId() {

        NoteResult<List<Book>> result = bookService.loadBooksByUserId("14103118");
        System.out.println(result);
    }

    @Test
    public void testFindNotesByBookId() {
        NoteResult<List<Note>> result = noteService.loadNotesByBookId("14103118");
        System.out.println(result);
    }

    @Test
    public void testFindNoteById() {
        NoteResult<Note> result = noteService.loadNoteByNoteId("note_id_1");
        System.out.println(result);
    }
}
