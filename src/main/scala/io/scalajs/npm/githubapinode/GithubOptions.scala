package io.scalajs.npm.githubapinode

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GitHub Optional Settings
  * @param username the GitHub user name
  * @param password the GitHub user's password
  * @param token    a GitHub authorization token
  * @param auth     a GitHub authorization
  * @param apiUrl   a GitHub authorization url
  */
@ScalaJSDefined
class GithubOptions(val username: js.UndefOr[String] = js.undefined,
                    val password: js.UndefOr[String] = js.undefined,
                    val token: js.UndefOr[String] = js.undefined,
                    val auth: js.UndefOr[String] = js.undefined,
                    val apiUrl: js.UndefOr[String] = js.undefined)
  extends js.Object
