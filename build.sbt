Global / onChangedBuildSource := ReloadOnSourceChanges

name    := "scala-template"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.13.4"
scalacOptions ++= Seq(
  "-deprecation",
  "-Xfatal-warnings",
)

libraryDependencies ++= Seq(
  "com.lihaoyi"       %% "pprint"                   % "0.6.0",
  "com.lihaoyi"       %% "fansi"                    % "0.2.9",
  "org.scalatest"     %% "scalatest-shouldmatchers" % "3.2.3",
  "org.scalatest"     %% "scalatest-funspec"        % "3.2.3",
)
