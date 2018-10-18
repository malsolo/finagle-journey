package com.malsolo.finagle.journey.quickstart

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}

/*
* Try with:
$ curl -D - localhost:8080
To obtain:
HTTP/1.1 200 OK
Content-Length: 0
*/
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
}
