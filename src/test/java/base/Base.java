package base;

import com.loop.dao.NotebookDao;
import com.loop.dao.NoteDao;
import com.loop.dao.UserDao;
import com.loop.service.NotebookService;
import com.loop.service.UserService;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.loop.service.NoteService;

public class Base {

    protected ClassPathXmlApplicationContext context;

    protected NotebookDao notebookDao;
    protected NotebookService notebookService;

    protected NoteDao noteDao;
    protected NoteService noteService;

    protected UserDao userDao;
    protected UserService userService;


    @Before
    public void initContext() {
        context = new ClassPathXmlApplicationContext(
                "conf/spring-mvc.xml",
                "conf/spring-mybatis.xml"
        );

        notebookDao = context.getBean("notebookDao", NotebookDao.class);
        notebookService = context.getBean("notebookService", NotebookService.class);

        noteDao = context.getBean("noteDao", NoteDao.class);
        noteService = context.getBean("noteService", NoteService.class);

        userDao = context.getBean("userDao", UserDao.class);
        userService = context.getBean("userService", UserService.class);
    }
}
