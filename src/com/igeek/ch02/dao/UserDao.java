package com.igeek.ch02.dao;

import com.igeek.ch02.entity.User;

import java.sql.SQLException;

/**
 * @Description TODO
 * @Author designal
 * @Date 2021/1/15 15:24
 */
public class UserDao extends BaseDao<User> {

    public User selectOne(String username, String password) throws SQLException {
        String sql = "select * from user where name = ? and pwd = ?";
        User user = this.getBean(sql, User.class, username, password);
        return user;
    }
}
