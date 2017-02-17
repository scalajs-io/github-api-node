package io.scalajs.npm.githubapinode

import io.scalajs.util.JSONHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

/**
  * User API Test Suite
  * @author lawrence.daniels@gmail.com
  */
class UsersTest extends FunSpec {

  describe("Users") {
    val gitHub = new GitHub(new GithubOptions())
    val user = gitHub.getUser()

    it("supports listing organizations the authenticated user belongs to.") {
      user.orgsAsync.future foreach { orgs =>
        info(s"orgs: ${orgs.toJson}")
      }
    }

    it("supports listing repositories of the authenticated user.") {
      user.reposAsync().future foreach { repos =>
        info(s"repos: ${repos.toJson}")
      }
    }

  }

}
