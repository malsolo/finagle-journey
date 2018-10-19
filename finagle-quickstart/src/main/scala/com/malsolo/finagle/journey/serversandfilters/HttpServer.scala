package com.malsolo.finagle.journey.serversandfilters

import com.twitter.finagle.{Http, Service, http}
import com.twitter.finagle.http.{Request, Response}
import com.twitter.util.{Await, Future}

object HttpServer extends App {

  println("HTTP Server.")

  val httpService = new Service[http.Request, http.Response] {
    override def apply(request: Request): Future[Response] = Future.value(Response())
  }

  val server = Http.serve(":8282", httpService)

  Await.ready(server)

}
