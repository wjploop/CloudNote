package com.loop.dao;

import com.loop.entity.User;
import org.springframework.stereotype.Repository;

/**
 * author  loop
 * create  2018-01-22 17:53.
 */

public interface UserDao {

    User findByName(String name);

    void saveUser(User user);

}
