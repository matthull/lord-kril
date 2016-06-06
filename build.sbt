name := "lord-krill"

organization := "org.matthull"

version := "0.1.0"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.6", "2.11.8")

resolvers ++= Seq(
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "2.2.6",
  "com.typesafe" % "config" % "1.3.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "com.github.scopt" %% "scopt" % "3.4.0",
  "joda-time" % "joda-time" % "2.9.3",
  "org.joda" % "joda-convert" % "1.8.1",
  "com.github.nscala-time" %% "nscala-time" % "2.12.0",
  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "org.json4s" %% "json4s-jackson" % "3.3.0",
  "org.json4s" %% "json4s-ext" % "3.3.0",
  "com.typesafe.akka" %% "akka-actor" % "2.4.7",
  "com.typesafe.akka" %% "akka-stream" % "2.4.7",
  "com.typesafe.akka" %% "akka-http-core" % "2.4.7",
  "com.typesafe.akka" %% "akka-http-experimental" % "2.4.7",
  "net.liftweb" %% "lift-json" % "2.6.3",
  "net.liftweb" %% "lift-json-ext" % "2.6.3",
  "io.netty" % "netty-all" % "4.1.0.Final",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.3",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.3",
  "org.scalikejdbc" %% "scalikejdbc" % "2.3.5",
  "mysql" % "mysql-connector-java" % "5.1.38",
  "com.amazon" % "redshift.jdbc41" % "1.1.13.1013" from "https://s3.amazonaws.com/redshift-downloads/drivers/RedshiftJDBC41-1.1.13.1013.jar",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalikejdbc" %% "scalikejdbc-test" % "2.3.5" % "test"
)


scalacOptions ++= Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:experimental.macros",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint",
    "-Yinline-warnings",
    "-Ywarn-dead-code",
    "-Xfuture")

initialCommands := "import org.matthull.lordkrill.api._"
