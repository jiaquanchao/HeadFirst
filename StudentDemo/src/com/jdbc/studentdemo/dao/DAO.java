package com.jdbc.studentdemo.dao;

import com.jdbc.studentdemo.JDBCTools;
import com.jdbc.studentdemo.ReflectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jax on 2016/11/6.
 */
public class DAO {

    Connection connection = null;

    public void update(String sql, Object ... args) {
        connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i< args.length; i ++) {
                preparedStatement.setObject(i+1, args[i]);
            }
            preparedStatement.executeUpdate(); //出过错
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(null, preparedStatement, connection);
        }
    }

    public void delete(String sql) {

    }


    public <T> T get(Class<T> clazz, String sql, Object ... args) {

        T entity = null;
        connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i< args.length; i ++) {
                preparedStatement.setObject(i+1, args[i]);
            }
            resultSet = preparedStatement.executeQuery(); //出过错
            Map<String, Object> map = new HashMap<String, Object>();
            if (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i ++) {
                    String columnName = resultSetMetaData.getColumnLabel(i+1);
                    Object fieldValue = resultSet.getObject(i+1);
                    map.put(columnName, fieldValue);
                }
                entity = clazz.newInstance();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    ReflectionUtils.setFieldValue(entity, entry.getKey(), entry.getValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(null, preparedStatement, connection);
        }

        return entity;
    }

    public <T> List<T> getForList(Class<T> clazz, String sql, Object ... args) {

        return null;
    }

    //返回某一个字段的值，或一个统计值。
    public <E> E getForValue(String sql, Object ... args) {

        return null;
    }
}
