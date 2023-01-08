Global / onChangedBuildSource := ReloadOnSourceChanges

name := "scala-template"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.13.10"

scalacOptions ++= Seq(
  "-deprecation",
//  "-Xfatal-warnings",
  "-Wunused"
)

libraryDependencies ++= Seq(
  "org.typelevel"     %% "cats-effect"              % "3.4.4",
  "io.circe"          %% "circe-parser"             % "0.14.3",
  "io.circe"          %% "circe-generic-extras"     % "0.14.3",
  "com.lihaoyi"       %% "pprint"                   % "0.8.1",
  "com.lihaoyi"       %% "fansi"                    % "0.4.0",
  "org.scalatest"     %% "scalatest-shouldmatchers" % "3.2.15",
  "org.scalatest"     %% "scalatest-funspec"        % "3.2.15",
  "org.scalacheck"    %% "scalacheck"               % "1.17.0",
  "org.scalatestplus" %% "scalacheck-1-17"          % "3.2.15.0"
)
