import java.io.{FileInputStream, InputStream}
import java.sql.DriverManager
import java.sql.Connection
import java.util.Properties

/**
  * Created by Jax on 2016/12/23.
  */
object jdbc {

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
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT \"ID\" FROM \"Unit\"")
      while ( resultSet.next() ) {
        val ID = resultSet.getString("ID")
        println("ID = " + ID)
      }
    } catch {
      case e => e.printStackTrace
    }
    connection.close()
  }
}
