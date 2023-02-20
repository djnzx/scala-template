Global / onChangedBuildSource := ReloadOnSourceChanges

name := "scala-template"
version := "0.0.1"

scalaVersion := "2.13.10"

javacOptions := Seq(
  "-source",
  "11",
  "-target",
  "11",
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
  "-Yrepl-class-based",
)

def http4s(artifact: String): ModuleID = "org.http4s" %% artifact % "1.0.0-M38"
def circe(artifact: String): ModuleID = "io.circe"    %% artifact % "0.14.3"

libraryDependencies ++= Seq(
  compilerPlugin("org.typelevel"  %% "kind-projector"     % "0.13.2" cross CrossVersion.full),
  compilerPlugin("com.olegpy"     %% "better-monadic-for" % "0.3.1"),
  compilerPlugin("org.augustjune" %% "context-applied"    % "0.1.4"),
  http4s("http4s-core"),
  http4s("http4s-dsl"),
  http4s("http4s-blaze-server"),
  http4s("http4s-blaze-client"),
  http4s("http4s-circe"),
  circe("circe-generic-extras"),
  circe("circe-parser"),
  "com.github.fd4s"   %% "fs2-kafka"                % "2.5.0-M3",
  "com.lihaoyi"       %% "pprint"                   % "0.8.1",
  "com.lihaoyi"       %% "fansi"                    % "0.4.0",
  "org.scalatest"     %% "scalatest-shouldmatchers" % "3.2.15",
  "org.scalatest"     %% "scalatest-funspec"        % "3.2.15",
  "org.scalacheck"    %% "scalacheck"               % "1.17.0",
  "org.scalatestplus" %% "scalacheck-1-17"          % "3.2.15.0",
)
