GitHub API for Scala.js
================================
[github-api-node](https://www.npmjs.com/package/github-api-node) - A higher-level wrapper around the Github API.

### Description

Github.js provides a minimal higher-level wrapper around git's plumbing commands, exposing an API for 
manipulating GitHub repositories on the file level. It was formerly developed in the context of Prose, 
a content editor for GitHub.

### Build Dependencies


* [SBT v0.13.13](http://www.scala-sbt.org/download.html)

### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

### Examples

```scala
import io.scalajs.nodejs.util.Util
import io.scalajs.npm.githubapinode._
import io.scalajs.util.JSONHelper._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

val gitHub = new GitHub(new GithubOptions())

// get the "bignum" repo for user "scalajs-io"
val repo = gitHub.getRepo("scalajs-io", "bignum")

// list the branches in the repo
repo.listBranchesAsync.future foreach { branches =>
  println(s"branches: ${branches.toJson}")
}

// list the contributors to the repo  
repo.contributorsAsync.future foreach { contributors =>
  println(s"contributors: ${Util.inspect(contributors)}")
}

// retrieve the contents of the master branch
repo.contentsAsync(branch = "master", pathToDir = ".").future foreach { contents =>
  println(s"contents: ${Util.inspect(contents)}")
}

// asynchronously read the contents of a file in the repo's master branch
repo.readAsync(branch = "master", pathToFile = "package.json").future foreach { data =>
  println(s"package.json: ${Util.inspect(data)}")
}
```

### Artifacts and Resolvers

To add the `GitHub` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "github-api-node" % "0.4.0-pre2"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
