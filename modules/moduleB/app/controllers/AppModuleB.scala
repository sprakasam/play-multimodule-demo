package controllers

import play.api.mvc.{Action, Controller}

object AppModuleB extends Controller {

  def index = Action { request =>
    Ok("I am the moduleB application")
  }

}

