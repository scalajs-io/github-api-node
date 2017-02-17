package io.scalajs.npm.githubapinode

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Represents a GitHub Pull
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class Pull(val title: String,
           val body: String,
           val base: String,
           val head: String) extends js.Object