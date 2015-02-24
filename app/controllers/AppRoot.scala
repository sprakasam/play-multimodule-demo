package controllers

import play.api.Play
import play.api.mvc.{Action, Controller}

object AppRoot extends Controller {
  
  def index = Action { request =>
    Ok("I am the root application")
  }

  def allConfigs = Action { request =>
    val keysFilter = (str: String) => str.contains("root") || str.contains("moduleA")
    val configs = Play.current.configuration.entrySet
      .filter(kv => keysFilter(kv._1)).map(kv => ("key = "+ kv._1, "value = " + kv._2.render())).mkString("", "\n", "")

    Ok(configs)
  }

}
