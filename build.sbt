name := "Kafka-Flink-Data-Pipeline"

version := "0.1"

scalaVersion := "2.11.7"

lazy val flinkVersion = "1.4.0"

libraryDependencies ++= Seq(
  "org.apache.kafka" %% "kafka" % "2.1.0",
  "com.typesafe" % "config" % "1.3.1",
  "org.apache.flink" %% "flink-scala" % flinkVersion,
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion,
  "org.apache.flink" %% "flink-streaming-java" % flinkVersion,
"org.apache.flink" %% "flink-connector-kafka-0.11" % flinkVersion

)
