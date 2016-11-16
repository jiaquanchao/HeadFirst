package com.jdbc;

import java.io.IOException;
import java.sql.*;

/**
 * Created by Jax on 2016/11/15.
 */
public class ReadUnit {

    private static String filePath = "D:/LabShare/维柴/维柴数据/";
    String sql = "SELECT  ?, ?, ? ,? , ?, ?, ? \n" +
            "FROM ? JOIN  ? ON ? = ?\n" +
            "  JOIN ? ON ? = ?\n" +
            "  JOIN ? ON  ? = ?\n" +
            "WHERE ? = ?  AND ? = ? ;\n";

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IOException, IllegalAccessException {

        connection = JBDCTools.getConnection();

    }

}
