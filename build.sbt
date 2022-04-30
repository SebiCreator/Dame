val scala3Version = "3.1.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Dame",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.11",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % "test"
    jacocoCoverallsServiceName := "github-actions",
    jacocoCoverallsBranch := sys.env.get("main"),
    jacocoCoverallsPullRequest := sys.env.get("GITHUB_EVENT_NAME"),
    jacocoCoverallsRepoToken := sys.env.get("COVERALLS_REPO_TOKEN")
  )
  .enablePlugins(JacocoCoverallsPlugin)

