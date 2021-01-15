package com.igeek.ch02.dao;

import com.igeek.ch02.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Description TODO
 * @Author designal
 * @Date 2021/1/15 15:21
 */
public class BaseDao<T> {

    QueryRunner queryRunner = new QueryRunner();

    //查询单个
    public T getBean(String sql,Class<T> clazz, Object...params) throws SQLException {
        T t = queryRunner.query(JDBCUtils.getConnection(), sql, new BeanHandler<>(clazz), params);
        return t;
    }
}
