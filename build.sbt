import scala.collection.Seq

Global / onChangedBuildSource := ReloadOnSourceChanges

name := "scala-template"
version := "0.0.1"

scalaVersion := "2.13.14"

javacOptions := Seq("-source", "17", "-target", "17")

scalacOptions ++= Seq(
  "-encoding",
  "UTF-8",
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:postfixOps",
  "-language:higherKinds",
  "-language:existentials",
  "-Wconf:cat=other-match-analysis:error",
  "-Wunused",
  //  "-Xfatal-warnings",
  "-Ymacro-annotations",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ywarn-dead-code",
  //  "-Ywarn-unused",
  "-Yrepl-class-based"
)

libraryDependencies ++= Seq(
  /** some useful plugin things */
  compilerPlugin("org.typelevel" %% "kind-projector"     % "0.13.3" cross CrossVersion.full),
  compilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1"),
  /** basic category things */
  "org.typelevel"     %% "cats-core"               % "2.12.0",
  /** effects */
  "org.typelevel"     %% "cats-effect"             % "3.5.4",
  "co.fs2"            %% "fs2-io"                  % "3.10.2",
  /** json serialization */
  "io.circe"          %% "circe-parser"            % "0.14.9",
  "io.circe"          %% "circe-generic-extras"    % "0.14.4",
  /** http */
  "org.http4s"        %% "http4s-dsl"              % "0.23.27",
  "org.http4s"        %% "http4s-circe"            % "0.23.27",
  "org.http4s"        %% "http4s-blaze-server"     % "0.23.16",
  "org.http4s"        %% "http4s-blaze-client"     % "0.23.16",
  /** PostgresSQL */
  "org.tpolecat"      %% "doobie-postgres"         % "1.0.0-RC5",
  "org.tpolecat"      %% "doobie-hikari"           % "1.0.0-RC5",
  "org.tpolecat"      %% "skunk-core"              % "0.6.4",
  "org.postgresql"     % "postgresql"              % "42.7.3",
  /** kafka */
  "com.github.fd4s"   %% "fs2-kafka"               % "3.5.1",
  /** enum support */
  "com.beachape"      %% "enumeratum"              % "1.7.4",
  "com.beachape"      %% "enumeratum-circe"        % "1.7.4",
  "com.beachape"      %% "enumeratum-doobie"       % "1.7.6", // doobie: 1.0.0-RC5
  "com.beachape"      %% "enumeratum-cats"         % "1.7.4",
  "com.beachape"      %% "enumeratum-scalacheck"   % "1.7.4",
  /** testing */
  "org.scalatest"     %% "scalatest"               % "3.2.19",
  "org.scalacheck"    %% "scalacheck"              % "1.18.0",
  "org.scalatestplus" %% "scalacheck-1-18"         % "3.2.19.0",
  "org.mockito"       %% "mockito-scala-scalatest" % "1.17.37",
  /** colored & informative output */
  "com.lihaoyi"       %% "pprint"                  % "0.9.0"
)
