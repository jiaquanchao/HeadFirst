package com.jdbc;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * Created by Jax on 2016/11/3.
 */
public class JDBCTest {
    /** Driver 接口
     * 加入驱动
     * 通过Driver数据库对象连接数据库
     */

    public Connection getConnection() throws Exception {

        //连接数据库的信息
        String driverClass = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;

        //读取配置文件
        InputStream in =
                getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(in);
        driverClass = properties.getProperty("driver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

        return connection;
    }

    @Test
    public void testGetConnection() throws Exception {
        //获取连接
        Connection connection = getConnection();

        //准备sql语句
        Statement statement = null;
        try {
            String sql = "CREATE TABLE javaTest(No., NUMBER(6))";

            //获取statement，并用executeUpdate来运行sql
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection.close();
            }
        }
    }

}
