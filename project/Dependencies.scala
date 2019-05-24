/*
 * Copyright (C) 2009-2017 Lightbend Inc. <https://www.lightbend.com>
 */
import sbt._
import sbt.Keys._

object Dependencies {
  val logback = Seq("ch.qos.logback" % "logback-core" % "1.2.3")

  val assertj = Seq("org.assertj" % "assertj-core" % "3.12.2")

  val awaitility = Seq("org.awaitility" % "awaitility" % "3.1.6")

  val specsVersion = "4.5.1"
  val specsBuild = Seq(
    "specs2-core",
    "specs2-junit",
    "specs2-mock"
  ).map("org.specs2" %% _ % specsVersion)

  val slf4jtest = Seq("uk.org.lidalia" % "slf4j-test" % "1.2.0")

  val junitInterface = Seq("com.novocode" % "junit-interface" % "0.11")

  val scalaJava8Compat = Seq("org.scala-lang.modules" %% "scala-java8-compat" % "0.9.0")

  val playJsonVersion = "2.8.0-M1"
  val playJson = Seq("com.typesafe.play" %% "play-json" % playJsonVersion)

  val slf4jApi = Seq("org.slf4j" % "slf4j-api" % "1.7.26")

  val javaxInject = Seq("javax.inject" % "javax.inject" % "1")

  val sslConfigVersion = "0.4.0"
  val sslConfigCore = Seq("com.typesafe" %% "ssl-config-core" % sslConfigVersion)

  val scalaXmlVersion = "1.2.0"
  val scalaXml = Seq("org.scala-lang.modules" %% "scala-xml" % scalaXmlVersion)

  val signpostVersion = "1.2.1.2"
  val oauth = Seq("oauth.signpost" % "signpost-core" % signpostVersion)

  val cachecontrolVersion = "2.0.0-M1"
  val cachecontrol = Seq("com.typesafe.play" %% "cachecontrol" % cachecontrolVersion)

  val asyncHttpClientVersion = "2.9.0"
  val asyncHttpClient = Seq("org.asynchttpclient" % "async-http-client" % asyncHttpClientVersion)

  val akkaVersion = "2.6.0-M2"
  val akkaStreams = Seq("com.typesafe.akka" %% "akka-stream" % akkaVersion)

  val akkaHttpVersion = Def.setting(CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 13)) => "10.1.8+26-f33ec39a"
    case _             => "10.1.8"
  })
  val akkaHttp = Def.setting(Seq("com.typesafe.akka" %% "akka-http" % akkaHttpVersion.value))

  val reactiveStreams = Seq("org.reactivestreams" % "reactive-streams" % "1.0.2")

  val testDependencies = (specsBuild ++ junitInterface ++ assertj ++ awaitility ++ slf4jtest ++ logback).map(_ % Test)

  val standaloneApiWSDependencies = javaxInject ++ sslConfigCore ++ akkaStreams ++ testDependencies

  val standaloneAhcWSDependencies = scalaJava8Compat ++ cachecontrol ++ slf4jApi ++ reactiveStreams ++ testDependencies

  val standaloneAhcWSJsonDependencies = playJson ++ testDependencies

  val standaloneAhcWSXMLDependencies = scalaXml ++ testDependencies

}
