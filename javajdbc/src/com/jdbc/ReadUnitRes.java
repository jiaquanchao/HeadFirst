package com.jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jax on 2016/12/24.
 */
public class ReadUnitRes {

    public static void read(String path) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String sqlRes = "SELECT u.\"ID\"UnitID,rt.\"FinalTorque\",rt.\"FinalAngle\",r.\"ResultStatusTypeID\" ResultType " +
                "FROM \"Result\"  r JOIN  \"Unit\" u ON r.\"UnitID\" = u.ID " +
                "JOIN \"ResultTightening\" rt ON  r.\"ID\" = rt.\"ResultID\" " +
                "WHERE u.\"ID\" = ";

//        ReadB readB = (ReadB) Class.forName("com.jdbc.ReadB").newInstance();
        String filePath = path; //"D:\\WCData\\ReadBlob\\";
        String sqlGetUnitID = "SELECT ID\n" +
                "FROM \"Unit\"";
//        String sql = "SELECT a.ResultID,a.UnitID,a.ResultType,a.ProcessTorque,g.\"GraphValues\"ProcessAngle\n" +
//                "FROM (SELECT  r.\"ID\"ResultID,u.\"ID\"UnitID,r.\"ResultStatusTypeID\"ResultType,g.\"GraphValues\"ProcessTorque\n" +
//                "FROM \"Result\"  r JOIN  \"Unit\" u ON r.\"UnitID\" = u.ID\n" +
//                "  JOIN \"Graph\"  g ON  r.ID= g.\"ResultID\"\n" +
//                "WHERE r.\"UnitID\"="+unitid+" AND r.\"ResultStatusTypeID\"='0 'AND g.\"GraphTypeID\"= -1)a JOIN \"Graph\" g ON  a.ResultID= g.\"ResultID\"\n" +
//                "  WHERE g.\"GraphTypeID\"= " + normal;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Integer> UnitID = new ArrayList<>();
        String resID;
        String resFT;
        String resFA;
        String resRT;

        try {
            conn = JBDCTools.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sqlGetUnitID);
            while (rs.next()) {
                UnitID.add(rs.getInt("ID"));
            }

            System.out.println(UnitID.toString());
            for (int unit :
                    UnitID) {
                File file = new File(filePath + unit + ".csv");
                if(file.exists()) {
                    file.delete();
                }
                Writer writer = new OutputStreamWriter(new FileOutputStream(file, true));
                writer.write("UnitID" + "," + "FinalTorque" + "," + "FinalAngle" + "," + "ResultType" + "\n");
                rs = stat.executeQuery(sqlRes + Integer.toString(unit));
                System.out.println(sqlRes + unit);
                System.out.println(file.getName());
                while (rs.next()) {
                    resID = rs.getString("UnitID");
                    resFT = rs.getString("FinalTorque");
                    resFA = rs.getString("FinalAngle");
                    resRT = rs.getString("ResultType");
                    writer.write(resID + "," + resFT + "," + resFA + "," + resRT + "\n");
                }
                writer.close();
//                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JBDCTools.release(rs, stat, conn);
        }
    }

    @org.junit.Test
    public void test() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String path = "D:\\Unit";
        read(path);
    }

}
