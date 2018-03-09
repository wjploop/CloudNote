package dao;

import com.loop.entity.User;
import com.loop.service.UserService;
import com.loop.util.NoteResult;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author  loop
 * create  2018-01-22 21:25.
 */


public class TestUserService {

    UserService userService;

    @Before
    public void init() {
        String[] conf = {"conf/spring-mvc.xml", "conf/spring-mybatis.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(conf);

        userService = context.getBean("userService", UserService.class);

    }

    //用例-1:预期结果，用户名不存在
    @Test
    public void test1() {
        NoteResult<User> noteResult = userService.login("qwer", "123");
        System.out.println(noteResult);
    }

    //用例-2:预期结果，密码不正确
    @Test
    public void test2() {
        NoteResult<User> noteResult = userService.login("loop", "qwer");
        System.out.println(noteResult);
    }

    //预期结果，登录成功
    @Test
    public void test3() {
        NoteResult noteResult = userService.login("loop", "123");
        System.out.println(noteResult);
    }

    @Test
    public void testRegister() {
        NoteResult<Object> result = userService.register("looper", "loop_nick", "1234");
        System.out.println(result);
    }



}
