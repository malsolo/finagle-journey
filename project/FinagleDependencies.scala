import sbt._

object FinagleDependencies {
  val finagleVersion = "18.9.1"

  lazy val finagle = "com.twitter" %% "finagle-http" % finagleVersion
}
