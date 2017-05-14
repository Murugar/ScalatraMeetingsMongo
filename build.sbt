import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._
import ScalateKeys._

val ScalatraVersion = "2.5.0"

ScalatraPlugin.scalatraSettings

scalateSettings

organization := "com.iqmsoft.scalatra.mongodb"

name := "Scalatra Meeting Room Bookings"

version := "0.1.0-SANPSHOT"

scalaVersion := "2.12.1"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
//  "org.mongodb" %% "casbah" % "3.1.1",
//  "org.scalatra" %% "scalatra" % ScalatraVersion,
//  "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
//  "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
//  //"ch.qos.logback" % "logback-classic" % "1.1.5" % "runtime",
//  "ch.qos.logback" % "logback-classic" % "1.1.1" % "runtime",
//  "org.mortbay.jetty" % "servlet-api" % "3.0.20100224" % "provided",
//  "org.eclipse.jetty" % "jetty-server" % "8.0.0.M3" % "container, compile",
//  "org.eclipse.jetty" % "jetty-util" % "8.0.0.M3" % "container, compile",
//  "org.eclipse.jetty" % "jetty-webapp" % "9.2.15.v20160210" % "container",
//  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
//  "org.json4s" % "json4s-jackson_2.10" % "3.1.0",
//  "org.json4s" % "json4s-mongo_2.10" % "3.1.0"

  "org.mongodb" %% "casbah" % "3.1.1",
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
  "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
  //"ch.qos.logback" % "logback-classic" % "1.1.5" % "runtime",
  "ch.qos.logback" % "logback-classic" % "1.1.1" % "runtime",
  "org.mortbay.jetty" % "servlet-api" % "3.0.20100224" % "provided",
  "org.eclipse.jetty" % "jetty-server" % "8.0.0.M3" % "container, compile",
  "org.eclipse.jetty" % "jetty-util" % "8.0.0.M3" % "container, compile",
  "org.eclipse.jetty" % "jetty-webapp" % "9.2.15.v20160210" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.json4s" % "json4s-jackson_2.10" % "3.2.10",
  "org.json4s" % "json4s-mongo_2.10" % "3.2.10"
)

scalateTemplateConfig in Compile := {
  val base = (sourceDirectory in Compile).value
  Seq(
    TemplateConfig(
      base / "webapp" / "WEB-INF" / "templates",
      Seq.empty,  /* default imports should be added here */
      Seq(
        Binding("context", "_root_.org.scalatra.scalate.ScalatraRenderContext", importMembers = true, isImplicit = true)
      ),  /* add extra bindings here */
      Some("templates")
    )
  )
}

enablePlugins(JettyPlugin)
