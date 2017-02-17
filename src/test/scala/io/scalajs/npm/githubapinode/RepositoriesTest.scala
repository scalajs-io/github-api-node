package io.scalajs.npm.githubapinode

import io.scalajs.nodejs.util.Util
import io.scalajs.util.JSONHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Repositories API Test Suite
  * @author lawrence.daniels@gmail.com
  */
class RepositoriesTest extends FunSpec {

  describe("Repositories") {
    val gitHub = new GitHub(new GithubOptions())
    val repo = gitHub.getRepo("scalajs-io", "bignum")

    it("supports retrieving the branches for a repository") {
      repo.listBranchesAsync.future foreach { branches =>
        info(s"branches: ${branches.toJson}")
      }
    }

    it("supports retrieving contributors for a repository") {
      repo.contributorsAsync.future foreach { contributors =>
        info(s"contributors: ${Util.inspect(contributors)}")
      }
    }

    it("supports retrieving the contents of a repository") {
      repo.contentsAsync(branch = "master", pathToDir = ".").future foreach { contents =>
        info(s"contents: ${Util.inspect(contents)}")
      }
    }

    it("supports retrieving files from a repository") {
      repo.readAsync(branch = "master", pathToFile = "package.json").future foreach { data =>
        info(s"package.json: ${Util.inspect(data)}")
      }
    }

  }

}
