// Copyright: 2017 https://github.com/cakesolutions/sbt-cake/graphs
// License: http://www.apache.org/licenses/LICENSE-2.0

import sbt._
import sbt.Keys._

/**
  * Dependencies referenced in sbt-cake plugins
  * TODO: CO-143: Ideally we should refactor all dependencies in a single place.
  */
object CakePluginDependencies {
  val header = "de.heikoseeberger" % "sbt-header" % "2.0.0"
  val dynver = "com.dwijnand" % "sbt-dynver" % "1.2.0"
  val pgp = "com.jsuereth" % "sbt-pgp" % "1.0.1"
  val sonatype = "org.xerial.sbt" % "sbt-sonatype" % "2.0"
  val scalastyle = "org.scalastyle" %% "scalastyle-sbt-plugin" % "0.8.0"
  // The following plugin is otherwise known as neo-sbt-scalafmt
  // - see: https://github.com/lucidsoftware/neo-sbt-scalafmt
  val scalafmt = "com.lucidchart" % "sbt-scalafmt-coursier" % "1.7"
}

