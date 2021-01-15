package com.igeek.ch02.service;

import com.igeek.ch02.dao.UserDao;
import com.igeek.ch02.entity.User;
import com.igeek.ch02.utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @Description TODO
 * @Author designal
 * @Date 2021/1/15 15:28
 */
public class UserService {

    private UserDao userDao = new UserDao();

    public User login(String username,String password){
        User user = null;
        try {
            user = userDao.selectOne(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }
        return user;
    }
}
