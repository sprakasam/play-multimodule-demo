package controllers

import com.typesafe.config.ConfigFactory
import play.api.{Configuration, Play}
import play.api.mvc.{Action, Controller}

object AppModuleA extends Controller {
  
  def index = Action { request =>
    Ok("I am the moduleA application")
  }
  
  def splitUrl = Action { request =>
    val url = request.queryString.get("url").get.head
    val split = com.sungevity.commons.Util.splitUrl(url)
    val responseStr = "%s => %s".format("(protocol, domain, tld)", split)
    Ok(responseStr)
  }
  
  def allConfigs = Action { request =>
    val keysFilter = (str: String) => str.contains("root") || str.contains("moduleA")
    val configs = ModuleA.config.entrySet
      .filter(kv => keysFilter(kv._1)).map(kv => ("key = "+ kv._1, "value = " + kv._2.render())).mkString("", "\n", "")
    Ok(configs)
  }

}

object ModuleA {
  val typeSafeConfig = ConfigFactory.load("application.conf")
  lazy val config = Play.current.configuration ++ Configuration(typeSafeConfig)
  
}

