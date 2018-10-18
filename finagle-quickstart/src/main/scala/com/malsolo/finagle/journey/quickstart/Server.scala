package com.malsolo.finagle.journey.quickstart

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}

object Server extends App {

  println("Server.")

  val service = new Service[http.Request, http.Response] {
    override def apply(request: http.Request): Future[http.Response] = {
      println("SERVER: request received.")
      Future.value(
        http.Response(request.version, http.Status.Ok)
      )
    }
  }

  val server = Http.serve(":8080", service)
  println("Server awaiting.")
  Await.ready(server)

  println("Server Done.") //You'll never see this
}
