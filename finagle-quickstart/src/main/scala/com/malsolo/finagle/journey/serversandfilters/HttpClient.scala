package com.malsolo.finagle.journey.serversandfilters

import com.twitter.finagle.{Http, Service, http}

object HttpClient extends App {

  println("HTTP Client.")

  val httpService: Service[http.Request, http.Response] = Http.newService("localhost:8282")

  httpService(http.Request("/")).onSuccess { response: http.Response =>
    println(s"received response (${response.statusCode}) ${response.contentString}")
  }

  Thread.sleep(250)
  println("HTTP Client. Done.")

}
