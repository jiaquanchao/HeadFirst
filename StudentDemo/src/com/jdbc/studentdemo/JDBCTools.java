package com.jdbc.studentdemo;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Jax on 2016/11/5.
 */
public class JDBCTools {

    @Test
    public void testGetConnection() throws Exception {
        Connection connection = getConnection();
        System.out.println(connection);
    }
    /**
     * 建立连接，配置文件需要设置
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        String driverClass = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;

        InputStream in =
                JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(in);
        driverClass = properties.getProperty("driverClass");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        jdbcUrl = properties.getProperty("jdbcUrl");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

        return connection;
    }

    /**
     * 关闭连接，包括ResultSet，Statement，Connection
     * @param resultSet
     * @param statement
     * @param conn
     */
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

    /**
     * 插入学生信息：
     * 使用 Statement 方法，该方法能够处理 sql 语句。
     * @param args
     * @param sql
     */
    public static void updateStudentInfo(String sql, Object ... args) throws Exception{
        Connection connection = null;
//        Statement statement = null;
        PreparedStatement preparedStatement = null;


        /*
        写 sql 语句
         */
//        String sql = "INSERT INTO UT VALUES (" +
//                student.getId()+",'"+
//                student.getName()+"','"+
//                student.getphoneNumber()+"')";
//        String sql = "INSERT INTO UT VALUES (?,?,?)";
        System.out.println(sql);
        try {
            connection = getConnection();
//            statement = connection.createStatement();
//            statement.executeUpdate(sql);
            preparedStatement = connection.prepareStatement(sql);
            String printInfo = null;
            for (int i = 0; i<args.length; i++){
                preparedStatement.setObject(i+1, args[i]);
                printInfo += String.valueOf(args[i])+" —— ";
            }
            preparedStatement.executeUpdate();
            System.out.println("插入数据\n"+printInfo+"\n成功...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(null, preparedStatement, connection);
            System.out.println("System close...");
        }

    }

    public static Student findByPhoneNumber(String phoneNumber) {
        Student student = null;

//        String sql = "SELECT * FROM UT WHERE \"PHONENUMBER\" = '"+phoneNumber+"'";
        String sql = "SELECT * FROM UT WHERE \"PHONENUMBER\" = ?";
        System.out.println(sql);
        student = findByColumns(sql, phoneNumber);

        return student;
    }

    public static Student findByName(String name) {
        Student student = null;
//        String sql = "SELECT * FROM UT WHERE \"NAME\" = '"+name+"'";
//        "SELECT * FROM UT WHERE \"NAME\" = 'Jax'";
        String sql = "SELECT * FROM UT WHERE \"NAME\" = ?";
        System.out.println(sql);
        student = findByColumns(sql, name);

        return student;
    }

    public static Student findByColumns(String sql, Object ... args) {
        Student student = new Student();
        Connection connection = null;
//        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
//            statement = connection.createStatement();
//            rs = statement.executeQuery(sql);
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i< args.length; i++) {
                preparedStatement.setObject(i+1, args[i]);
            }
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                student.setId(Long.parseLong(rs.getString("Id")));
                student.setName(rs.getString("Name"));
                student.setphoneNumber(rs.getString("PhoneNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(rs,preparedStatement, connection);
        }
        return student;
    }

}
