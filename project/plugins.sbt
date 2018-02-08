resolvers += Resolver.sonatypeRepo("public")
resolvers += "Qvantel plugins Release" at "https://artifactory.qvantel.net/artifactory/plugins-release/"
resolvers += "Qvantel libs Release" at "https://artifactory.qvantel.net/artifactory/libs-release/"
logLevel := Level.Warn
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.2.1")
addSbtPlugin("com.lucidchart"   % "sbt-scalafmt"    % "1.14")
addSbtPlugin("com.lightbend.sbt" % "sbt-aspectj"        % "0.11.0")
addSbtPlugin("io.kamon"         % "sbt-aspectj-runner" % "1.0.4")
addSbtPlugin("com.typesafe.sbt"   % "sbt-native-packager"  % "1.3.2")
addSbtPlugin("com.lightbend.sbt"  % "sbt-javaagent"        % "0.1.4")
