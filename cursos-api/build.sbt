name := """cursos-api"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += javaJpa
libraryDependencies += cacheApi
libraryDependencies += ehcache
libraryDependencies += "com.h2database" % "h2" % "1.4.194"
libraryDependencies += "org.hibernate" % "hibernate-core" % "5.2.5.Final"
libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1103-jdbc41"

libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
