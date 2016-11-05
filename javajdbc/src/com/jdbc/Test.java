package com.jdbc;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by Jax on 2016/11/4.
 */
public class Test {

    @org.junit.Test
    public void connTest() throws Exception {
//        System.out.println(JBDCTools.getConnection());
        Connection conn = JBDCTools.getConnection();

//        String sql = "CREATE TABLE dpltest(No NUMBER (8))";
        String sql = "DROP TABLE DPLTEST";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);

        statement.close();
        conn.close();

    }
}
