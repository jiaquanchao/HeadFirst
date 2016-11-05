package com.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by Jax on 2016/11/4.
 */
public class TJDBC {

    public static Connection getConnection() throws Exception {

        InputStream in =
                TJDBC.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties info = new Properties();
        info.load(in);
        String driverClass = info.getProperty("driver");
        String jdbcUrl = info.getProperty("jdbcUrl");
        String user = info.getProperty("user");
        String password = info.getProperty("password");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

        return connection;
    }

}
