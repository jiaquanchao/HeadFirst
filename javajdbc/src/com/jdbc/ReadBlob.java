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

    public static void read(int unitid, int normal, int num, String path) throws Exception {

        ReadB readB = (ReadB) Class.forName("com.jdbc.ReadB").newInstance();
        String filePath = path; //"D:\\WCData\\ReadBlob\\";
        String sql = "SELECT a.ResultID,a.UnitID,a.ResultType,a.ProcessTorque,g.\"GraphValues\"ProcessAngle\n" +
                "FROM (SELECT  r.\"ID\"ResultID,u.\"ID\"UnitID,r.\"ResultStatusTypeID\"ResultType,g.\"GraphValues\"ProcessTorque\n" +
                "FROM \"Result\"  r JOIN  \"Unit\" u ON r.\"UnitID\" = u.ID\n" +
                "  JOIN \"Graph\"  g ON  r.ID= g.\"ResultID\"\n" +
                "WHERE r.\"UnitID\"="+unitid+" AND r.\"ResultStatusTypeID\"='0 'AND g.\"GraphTypeID\"= -1)a JOIN \"Graph\" g ON  a.ResultID= g.\"ResultID\"\n" +
                "  WHERE g.\"GraphTypeID\"= " + normal;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = JBDCTools.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            File file = new File(filePath+unitid+"_OK.csv");
            int count_i = 0;
            while (rs.next() && count_i <= num) {
                long resultId = rs.getLong("ResultId");
                int unitId = rs.getInt("UnitId");
                Blob ftP = rs.getBlob("ProcessTorque");
                Blob faP = rs.getBlob("ProcessAngle");
                readB.readB(resultId, ftP, faP, file);
                count_i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JBDCTools.release(rs, stat, conn);
        }
    }

    @org.junit.Test
    public void test() throws Exception {
        read(16506, -2, 10, "D:\\WCData\\");
    }

}
