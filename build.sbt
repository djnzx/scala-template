Global / onChangedBuildSource := ReloadOnSourceChanges

name    := "scala-template"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.13.5"
scalacOptions ++= Seq(
  "-deprecation",
  "-Xfatal-warnings",
  "-Wunused",
)

libraryDependencies ++= Seq(
  "com.lihaoyi"       %% "pprint"                   % "0.6.1",
  "com.lihaoyi"       %% "fansi"                    % "0.2.10",
  "com.lihaoyi"       %% "upickle"                  % "1.2.3",
  "org.scalatest"     %% "scalatest-shouldmatchers" % "3.2.5",
  "org.scalatest"     %% "scalatest-funspec"        % "3.2.5",
  "org.scalacheck"    %% "scalacheck"               % "1.15.3",
)
