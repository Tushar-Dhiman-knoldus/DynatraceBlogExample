ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "DynatraceExample"
  )

libraryDependencies ++= Seq(
  "org.apache.logging.log4j" % "log4j-api" % "2.20.0",
  "org.apache.logging.log4j" % "log4j-core" % "2.20.0",
  "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.20.0",
  "com.typesafe.akka" %% "akka-actor" % "2.8.0",
)
