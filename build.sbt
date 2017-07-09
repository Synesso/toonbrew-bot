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
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "com.github.austinv11" % "Discord4J" % "2.8.4"
)

enablePlugins(DockerPlugin)

imageNames in docker := Seq(ImageName(s"synesso/toonbrew-bot:${git.gitHeadCommit.value.get}"))

docker := (docker dependsOn assembly).value

dockerfile in docker := {
  val artifact = (assemblyOutputPath in assembly).value
  val artifactTargetPath = "/app/server.jar"
  new Dockerfile {
    from("java:8")
    maintainer("eqdata", "jem.mawson@gmail.com")
    add(artifact, artifactTargetPath)
    entryPoint("java", "-jar", artifactTargetPath)
  }
}
