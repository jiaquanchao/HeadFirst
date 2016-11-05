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
        String sql = "SELECT a.ResultID,a.UnitID,a.ResultType,a.ProcessTorque,g.\"GraphValues\"ProcessAngle\n" +
                "FROM (SELECT  r.\"ID\"ResultID,u.\"ID\"UnitID,r.\"ResultStatusTypeID\"ResultType,g.\"GraphValues\"ProcessTorque\n" +
                "FROM \"Result\"  r JOIN  \"Unit\" u ON r.\"UnitID\" = u.ID\n" +
                "  JOIN \"Graph\"  g ON  r.ID= g.\"ResultID\"\n" +
                "WHERE r.\"UnitID\"=16506 AND r.\"ResultStatusTypeID\"='0 'AND g.\"GraphTypeID\"= -1)a JOIN \"Graph\" g ON  a.ResultID= g.\"ResultID\"\n" +
                "  WHERE g.\"GraphTypeID\"= -2 ";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = JBDCTools.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            File file = new File(filePath+"16506_OK.csv");
            while (rs.next()) {
                long resultId = rs.getLong("ResultId");
                int unitId = rs.getInt("UnitId");
                Blob ftP = rs.getBlob("ProcessTorque");
                Blob faP = rs.getBlob("ProcessAngle");
                readB.readB(resultId, ftP, faP, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JBDCTools.release(rs, stat, conn);
        }
    }


}
