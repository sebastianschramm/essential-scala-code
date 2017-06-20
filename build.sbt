scalaVersion := "2.11.8"

scalacOptions += "-Xfatal-warnings"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1" % Test,
  "org.scalatest" %% "scalatest" % "3.0.1" % Test
)

scalacOptions ++= Seq("-Xfatal-warnings")


//alternative specs2 - might be slower during compiling compared to scalatest
