package io.scalajs.npm.githubapinode

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Represents a Reference Spec
  * @param ref the reference (e.g. "refs/heads/my-new-branch-name")
  * @param sha the SHA (e.g. "827efc6d56897b048c772eb4087f854f46256132")
  */
@ScalaJSDefined
class RefSpec(val ref: String, val sha: String) extends js.Object
