Global / onChangedBuildSource := ReloadOnSourceChanges

name := "scala-template"
version := "0.0.1"

scalaVersion := "2.13.11"

javacOptions := Seq(
  "-source",
  "17",
  "-target",
  "17"
)

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
  compilerPlugin("org.typelevel"  %% "kind-projector"     % "0.13.2" cross CrossVersion.full),
  compilerPlugin("com.olegpy"     %% "better-monadic-for" % "0.3.1"),
  compilerPlugin("org.augustjune" %% "context-applied"    % "0.1.4"),
  /** basic category things */
  "org.typelevel"     %% "cats-core"               % "2.9.0",
  /** effects */
  "org.typelevel"     %% "cats-effect"             % "3.5.1",
  "co.fs2"            %% "fs2-io"                  % "3.8.0",
  /** json serialization */
  "io.circe"          %% "circe-parser"            % "0.14.5",
  "io.circe"          %% "circe-generic-extras"    % "0.14.3",
  /** http */
  "org.http4s"        %% "http4s-dsl"              % "0.23.18",
  "org.http4s"        %% "http4s-circe"            % "0.23.18",
  "org.http4s"        %% "http4s-blaze-server"     % "0.23.15",
  "org.http4s"        %% "http4s-blaze-client"     % "0.23.15",
  /** PostgreSQL */
  "org.tpolecat"      %% "doobie-postgres"         % "1.0.0-RC2",
  "org.tpolecat"      %% "doobie-hikari"           % "1.0.0-RC2",
  "org.postgresql"     % "postgresql"              % "42.6.0",
  /** kafka */
  "com.github.fd4s"   %% "fs2-kafka"               % "2.6.1",
  /** enum support */
  "com.beachape"      %% "enumeratum"              % "1.7.3",
  "com.beachape"      %% "enumeratum-circe"        % "1.7.3",
  "com.beachape"      %% "enumeratum-doobie"       % "1.7.3",
  "com.beachape"      %% "enumeratum-cats"         % "1.7.3",
  "com.beachape"      %% "enumeratum-scalacheck"   % "1.7.3",
  /** testing */
  "org.scalatest"     %% "scalatest"               % "3.2.16",
  "org.scalacheck"    %% "scalacheck"              % "1.17.0",
  "org.scalatestplus" %% "scalacheck-1-17"         % "3.2.16.0",
  "org.mockito"       %% "mockito-scala-scalatest" % "1.17.14",
  /** colored & informative output */
  "com.lihaoyi"       %% "pprint"                  % "0.8.1",
  "com.lihaoyi"       %% "fansi"                   % "0.4.0"
)
