package com.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Jax on 2016/11/4.
 */
public class JBDCTools {


    public static Connection getConnection() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException, IOException {

        String driverClass = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;

        InputStream in =
                JBDCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(in);
        driverClass = properties.getProperty("driver");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        jdbcUrl = properties.getProperty("jdbcUrl");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

        return connection;
    }


    public static void release(Statement statement, Connection conn) {

        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public static void release(ResultSet resultSet, Statement statement, Connection conn) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    public static void updata(String sql) throws ClassNotFoundException, SQLException, InstantiationException, IOException, IllegalAccessException {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(statement, connection);
        }
    }

    public static ResultSet ResultSet(String sql) throws Exception{
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        connection = getConnection();
        statement = connection.createStatement();
        rs = statement.executeQuery(sql);
//        try {
//            connection = getConnection();
//            statement = connection.createStatement();
//            rs = statement.executeQuery(sql);
////            while (rs.next()) {
////                int unitId = rs.getInt(2);
////                Blob ftP = rs.getBlob(12);
////                Blob faP = rs.getBlob(13);
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            release(rs, statement, connection);
//        }
        return rs;
    }
}
