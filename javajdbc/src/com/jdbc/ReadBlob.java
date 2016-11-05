package com.jdbc;

import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Jax on 2016/11/5.
 */
public class ReadBlob {

    public static void main(String[] args) throws Exception {

        ReadB readB = (ReadB) Class.forName("com.jdbc.ReadB").newInstance();
        String filePath = "D:\\WCData\\ReadBlob\\";
        String sql = "SELECT * FROM UNIT16574G";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = JBDCTools.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                long resultId = rs.getLong(1);
                int unitId = rs.getInt(2);
                Blob ftP = rs.getBlob(12);
                Blob faP = rs.getBlob(13);
                File file = new File(filePath+unitId+"_"+resultId + ".csv");
                readB.readB(ftP, faP, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JBDCTools.release(rs, stat, conn);
        }
    }


}
