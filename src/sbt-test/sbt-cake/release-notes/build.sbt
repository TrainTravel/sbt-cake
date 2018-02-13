// Copyright: 2017 https://github.com/cakesolutions/sbt-cake/graphs
// License: http://www.apache.org/licenses/LICENSE-2.0

import java.net.URL

import net.cakesolutions.CakePlatformDependencies._
import net.cakesolutions.CakePublishMavenPluginKeys._
import net.cakesolutions.ReleaseNotesPluginKeys._

name in ThisBuild := "release_notes"

enablePlugins(CakeBuildPlugin, CakeJavaAppPlugin, ReleaseNotesPlugin)

snapshotRepositoryResolver :=
  Some(Resolver.file("file", new File(s"${target.value}/snapshot")))

repositoryResolver :=
  Some(Resolver.file("file", new File(s"${target.value}/release")))

issueManagementUrl := Some(new URL("http://localhost:8080"))

issueManagementProject := Some("SBTTesting")

versionControlUrl := Some(new URL("http://localhost:8080"))

libraryDependencies ++= Seq(
  Akka.Http.base,
  Akka.Http.core,
  Akka.Http.sprayJson,
  Akka.Http.testkit % Test,
  Jackson.databind,
  Jackson.scala,
  swagger
)

mainClass in Compile := Some("MockIssueManagementServer")

val nullLogger = new ProcessLogger {
  def info(s: => String): Unit = ()
  def error(s: => String): Unit = ()
  def buffer[T](f: => T): T = f
}

// We use SBT build tasks to ensure that the mock server actually runs in a
// separate process fork!

val startServer = taskKey[Unit]("Start mock issue management server")
startServer := {
  Process("./start-server.sh").run(nullLogger)
}

val stopServer = taskKey[Unit]("Stop mock issue management server")
stopServer := {
  Process("./stop-server.sh").run(nullLogger)
}
