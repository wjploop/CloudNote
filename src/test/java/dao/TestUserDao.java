package dao;

import base.Base;
import com.loop.entity.User;
import org.junit.Test;

public class TestUserDao extends Base {

    @Test
    public void testFindByName() {
        System.out.println(userDao.findByName("loop"));

    }

    @Test
    public void tesetAddUser() {
        User user = new User("user_id_3", "wolf", "123", "", "nick");
        userDao.addUser(user);
    }

    @Test
    public void testFindById() {
        System.out.println(userDao.findUserById("user_id_3"));

    }

}
