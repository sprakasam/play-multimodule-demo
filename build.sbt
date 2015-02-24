import _root_.sbt.Keys._

name := "play-multimodule-demo"

scalaVersion := "2.10.4"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .dependsOn(moduleA, moduleB)
  .aggregate(moduleA, moduleB)

lazy val moduleA: Project = (project in file("modules/moduleA")).enablePlugins(PlayScala).dependsOn(commons)

lazy val moduleB: Project = (project in file("modules/moduleB")).enablePlugins(PlayScala).dependsOn(commons)

lazy val commons: Project = project in file("commons")


