import Dependencies._

ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.malsolo"

lazy val root = (project in file("."))
  .aggregate(finagleQuickstart)
  .settings(
    inThisBuild(List(
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "finagle-journey",
    libraryDependencies += scalaTest % Test
  )

lazy val finagleQuickstart = (project in file("finagle-quickstart"))
  .settings(
    name := "finagle-quickstart",
    libraryDependencies += scalaTest % Test
  )


