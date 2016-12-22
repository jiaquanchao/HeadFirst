name := "cluster"

version := "1.0"

scalaVersion := "2.12.1"

resolvers += "Hortonworks Repository" at "http://repo.hortonworks.com/content/repositories/releases/"

resolvers += "Hortonworks Jetty Maven Repository" at "http://repo.hortonworks.com/content/repositories/jetty-hadoop/"

libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.0.2.4.0.1-6" excludeAll(
  ExclusionRule(organization = "org.scala-lang"),
  ExclusionRule(organization = "org.apache.hadoop"))

libraryDependencies ++= Seq(
  "org.apache.hbase" % "hbase-client" % "1.2.2" excludeAll ExclusionRule(organization = "org.apache.hadoop"),
  "org.apache.hbase" % "hbase-common" % "1.2.2" excludeAll ExclusionRule(organization = "org.apache.hadoop"),
  "org.apache.hbase" % "hbase-server" % "1.2.2" excludeAll ExclusionRule(organization = "org.apache.hadoop"),
  "org.apache.hbase" % "hbase-hadoop-compat" % "1.2.2" excludeAll ExclusionRule(organization = "org.apache.hadoop"),
  "org.apache.hbase" % "hbase-hadoop2-compat" % "1.2.2" excludeAll ExclusionRule(organization = "org.apache.hadoop"))

libraryDependencies += "org.apache.sqoop" % "sqoop-client" % "1.99.6" excludeAll ExclusionRule(organization = "org.apache.hadoop")

libraryDependencies ++= Seq(
  "org.apache.poi" % "poi" % "3.14",
  "org.apache.poi" % "poi-ooxml" % "3.14"
)

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.3.15"

libraryDependencies += "org.scala-lang.modules" % "scala-async_2.10" % "0.9.5"

mainClass in assembly := Some("com.weichai.bigdata.example.spark.SparkDemo")

assemblyMergeStrategy in assembly := {
  case m if m.toLowerCase.endsWith("manifest.mf")          => MergeStrategy.discard
  case m if m.toLowerCase.matches("meta-inf.*\\.sf$")      => MergeStrategy.discard
  case "META-INF/jersey-module-version"        => MergeStrategy.first
  case _                                       => MergeStrategy.first
}
