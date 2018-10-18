package com.malsolo.finagle.journey.quickstart

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}

object Client extends App {

  println("Client.")

  val client: Service[http.Request, http.Response] = Http.newService("localhost:8080")

  val request = http.Request(http.Method.Get, "/")

  request.host = "localhost"

  val response: Future[http.Response] = client(request)

  Await.result(response.onSuccess { rep: http.Response =>
    println("GET success: " + rep)
  })

  println("Client DONE.")

}
