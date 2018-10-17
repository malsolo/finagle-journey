import Dependencies._

ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.malsolo"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "finagle-journey",
    libraryDependencies += scalaTest % Test
  )

