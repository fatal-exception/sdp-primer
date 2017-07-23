name := "NumberPersonalities"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

//parallelExecution in Test := false
//concurrentRestrictions in Global += Tags.limit(Tags.Test, 1)
