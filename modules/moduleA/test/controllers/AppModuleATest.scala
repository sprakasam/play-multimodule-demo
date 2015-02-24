package controllers

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}


@RunWith(classOf[JUnitRunner])
class AppModuleATest extends Specification {
  "index" should {
    "return the name of the application" in new WithApplication {
      val getRequest = FakeRequest(GET, "/moduleA/index")

      // TODO: route() doesn't work -- FIX IT
      //      val  future = route(getRequest).get

      val future = AppModuleA.index.apply(getRequest)
      status(future) mustEqual 200
      contentAsString(future) mustEqual "I am the moduleA application"
    }
  }
}
