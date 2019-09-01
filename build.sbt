import sbt.Keys._

import sbt._

name := "ensembl-scala"

organization := "group.aging-research"

scalaVersion :=  "2.13.0"

crossScalaVersions := Seq("2.13.0", "2.12.19")

version := "0.0.2"

isSnapshot := false

resolvers += Resolver.bintrayRepo("comp-bio-aging", "main")

libraryDependencies ++= Seq(
 "com.lihaoyi" %% "requests" % "0.2.0",
 "com.lihaoyi" %% "upickle" % "0.7.5",
 "com.lihaoyi" %% "pprint" % "0.5.5",
 "org.scala-lang.modules" %% "scala-collection-compat" % "2.1.2",
 "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oF")

bintrayRepository := "main"

bintrayOrganization := Some("comp-bio-aging")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
