package com.sungevity.commons

object Util {
  
  def splitUrl(url: String): (String, String, String) = {
    val URL = """(http|ftp)://(.*)\.([a-z]+)""".r

    url match {
      case URL(protocol, domain, tld) => (protocol, domain, tld)
      case _                          => throw new RuntimeException("unable to parse the given url %s".format(url))
    }
    
  }
}
