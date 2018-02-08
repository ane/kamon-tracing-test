scalaVersion in ThisBuild := "2.11.12"

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
  "ch.qos.logback"    %  "logback-classic" % "1.2.3",
  "com.typesafe.akka" %% "akka-actor"      % "2.4.20",
  "com.typesafe.akka" %% "akka-slf4j" % "2.4.20",
  "io.kamon" %% "kamon-core" % "1.0.0",
  "io.kamon" %% "kamon-scala-future" % "1.0.0",
  "io.kamon" %% "kamon-logback" % "1.0.0",
  "io.kamon" %% "kamon-akka-2.4" % "1.0.0"
)

fork in run := true
connectInput in run := true
cancelable in Global := true
