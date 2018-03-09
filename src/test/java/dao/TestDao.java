package dao;

import com.loop.dao.BookDao;
import com.loop.dao.NoteDao;
import com.loop.dao.UserDao;
import com.loop.entity.Book;
import com.loop.entity.Note;
import com.loop.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * author  loop
 * create  2018-01-22 18:03.
 */


public class TestDao {

    UserDao userDao;
    BookDao bookDao;
    NoteDao noteDao;

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
        userDao = context.getBean("userDao", UserDao.class);
        bookDao = context.getBean("bookDao", BookDao.class);
        noteDao = context.getBean("noteDao", NoteDao.class);

    }

    @Test
    public void testFindByName() {
        User user = userDao.findByName("loop");
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setId("10086");
        user.setName("China Mobile");
        user.setPassword("123");
        userDao.saveUser(user);
    }
    @Test
    public void testBookDao() {
        List<Book> list=bookDao.findBooksByUserId("14103118");
        System.out.println(list);
    }
    @Test
    public void testNoteDao() {
        List<Note> notes = noteDao.findNotesByBookId("book_id_1");
        System.out.println(notes);
    }

    @Test
    public void testNoteDaoFindNoteById() {
        Note note = noteDao.findNoteById("note_id_1");
        System.out.println(note);
    }

}
