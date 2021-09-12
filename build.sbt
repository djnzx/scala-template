Global / onChangedBuildSource := ReloadOnSourceChanges

name := "scala-template"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.13.6"

scalacOptions ++= Seq(
  "-deprecation",
  "-Xfatal-warnings",
  "-Wunused",
)

libraryDependencies ++= Seq(
  "com.lihaoyi" %% "pprint" % "0.6.6",
  "com.lihaoyi" %% "fansi" % "0.2.14",
  "com.lihaoyi" %% "upickle" % "1.4.1",
  "org.scalatest" %% "scalatest-shouldmatchers" % "3.2.9",
  "org.scalatest" %% "scalatest-funspec" % "3.2.9",
  "org.scalacheck" %% "scalacheck" % "1.15.4",
)
