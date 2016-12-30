import java.io._
import java.sql.DriverManager
import java.sql.Connection
import java.util.Properties

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Jax on 2016/12/23.
  */
object jdbc {


  def getRes(str: String) = {

  }
  def main(args: Array[String]) {
    // connect to the database named "oracle" on the localhost
    val properties = new Properties();
    val in = Thread.currentThread().getContextClassLoader.getResource("jdbc.properties").getPath
    properties.load(new FileInputStream(in))
    val driver = properties.getProperty("driver")
    val url = properties.getProperty("jdbcUrl")
    val username = properties.getProperty("user")
    val password = properties.getProperty("password")

    // there's probably a better way to do this
    var connection:Connection = null

    val sqlGetUnitID: String = "\"SELECT \"ID\" FROM \"Unit\""
    var unitid: Int = 0
    var normal: Int = 0
    val unit = ArrayBuffer[String]()
    val resID, resFT, resFA, resRT = ArrayBuffer[String]()
    var sqlRes = "SELECT u.\"ID\"UnitID,rt.\"FinalTorque\",rt.\"FinalAngle\",r.\"ResultStatusTypeID\" ResultType "+
      "FROM \"Result\"  r JOIN  \"Unit\" u ON r.\"UnitID\" = u.ID "+
      "JOIN \"ResultTightening\" rt ON  r.\"ID\" = rt.\"ResultID\" " +
      "WHERE u.\"ID\" = "
    lazy val sql: String = "SELECT a.ResultID,a.UnitID,a.ResultType,a.ProcessTorque,g.\"GraphValues\"ProcessAngle\n" +
      "FROM (SELECT  r.\"ID\"ResultID,u.\"ID\"UnitID,r.\"ResultStatusTypeID\"ResultType,g.\"GraphValues\"ProcessTorque\n" +
      "FROM \"Result\"  r JOIN  \"Unit\" u ON r.\"UnitID\" = u.ID\n" + "  JOIN \"Graph\"  g ON  r.ID= g.\"ResultID\"\n" +
      "WHERE r.\"UnitID\"=" + unitid +
      " AND r.\"ResultStatusTypeID\"='0 'AND g.\"GraphTypeID\"= -1)a JOIN \"Graph\" g ON  a.ResultID= g.\"ResultID\"\n" +
      "  WHERE g.\"GraphTypeID\"= " + normal


    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statementUnitID = connection.createStatement()
      val statementRes = connection.createStatement()
      val resultSet = statementUnitID.executeQuery(sqlGetUnitID)
      while ( resultSet.next() ) {
        unit += resultSet.getString("ID")
      }
      println(unit.toString())
      for(u <- unit) {
        val resultSetRes = statementRes.executeQuery(sqlRes + u)
        while (resultSetRes.next()) {
          resID += resultSetRes.getString("UnitID")
          resFT += resultSetRes.getString("FinalTorque")
          resFA += resultSetRes.getString("FinalAngle")
          resRT += resultSetRes.getString("ResultType")
        }
        val tem = resID.zipAll(resFT, resFA, resRT)
        val file: String = "D:/"
//        val writer: Writer = new OutputStreamWriter(new FileOutputStream(file + unitid + ".csv", true))
        val writer: Writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file + unitid + ".csv", true)))
        for(u <- tem) {
          writer.write(u)
        }
        while ((inputStreamT.read(bytesT) != -1) && (inputStreamA.read(bytesA) != -1)) {
          val ftemp: Float = ReadB.byte2float(bytesT, 0)
          val atemp: Float = ReadB.byte2float(bytesA, 0)
          writer.write(String.valueOf(resultId) + "," + String.valueOf(ftemp) + "," + String.valueOf(atemp) + "\n")
        }
        inputStreamT.close
        inputStreamA.close
        writer.close
      }
    } catch {
      case e => e.printStackTrace
    }
    connection.close()
  }
}
