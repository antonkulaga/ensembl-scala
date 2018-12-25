import sbt.Keys._

import sbt._

name := "ensemble-scala"

organization := "group.aging-research"

scalaVersion :=  "2.12.8"

version := "0.0.1"

isSnapshot := false

resolvers += Resolver.bintrayRepo("comp-bio-aging", "main")

libraryDependencies ++= Seq(
 "com.lihaoyi" %% "requests" % "0.1.4",
 "com.lihaoyi" %% "upickle" % "0.7.1",
 "org.scalatest" %% "scalatest" % "3.0.5" % Test
)

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oF")

bintrayRepository := "main"

bintrayOrganization := Some("comp-bio-aging")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
