package com.igeek.ch02.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description TODO
 * @Author designal
 * @Date 2021/1/15 15:14
 */
public class JDBCUtils {

    private static ComboPooledDataSource pool = new ComboPooledDataSource("mysql");

    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    //获取链接对象
    public static Connection getConnection(){
        Connection connection = tl.get();
        try {
            if(connection==null || connection.isClosed()){
                connection = pool.getConnection();
                tl.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //释放链接
    public static void closeConnection(){
        Connection connection = tl.get();
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
