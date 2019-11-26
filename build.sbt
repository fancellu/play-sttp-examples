name := "play-sttp-examples"
 
version := "1.0" 
      
lazy val `playsttpexamples` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.10"

val sttpversion="2.0.0-RC2"

libraryDependencies ++= Seq(ws, guice,
  "com.softwaremill.sttp.client" %% "core" % sttpversion,
  "com.softwaremill.sttp.client" %% "async-http-client-backend-future" % sttpversion)
