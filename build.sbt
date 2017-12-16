name := "toonbrew-bot"

organization := "com.github.synesso"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  "jcenter repo" at "http://jcenter.bintray.com",
  "jitpack repo" at "https://jitpack.io"
)

libraryDependencies ++= Seq(
  "io.spray" %% "spray-json" % "1.3.3",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "com.typesafe" % "config" % "1.3.1",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "com.github.austinv11" % "Discord4J" % "2.9.3",
  "org.specs2" %% "specs2-core" % "3.9.5" % "test",
  "org.specs2" %% "specs2-scalacheck" % "3.9.5" % "test"
)

enablePlugins(DockerPlugin)

imageNames in docker := Seq(
  ImageName(s"synesso/toonbrew-bot:${git.gitHeadCommit.value.get}"),
  ImageName(s"synesso/toonbrew-bot:latest")
)

docker := (docker dependsOn assembly).value

dockerfile in docker := {
  val artifact = (assemblyOutputPath in assembly).value
  val artifactTargetPath = "/app/server.jar"
  new Dockerfile {
    from("openjdk:8-jre-alpine")
    maintainer("Jem Mawson", "jem.mawson@gmail.com")
    add(artifact, artifactTargetPath)
    entryPoint("java", "-jar", artifactTargetPath)
  }
}
