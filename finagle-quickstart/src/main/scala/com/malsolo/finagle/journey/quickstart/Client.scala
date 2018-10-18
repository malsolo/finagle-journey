package com.malsolo.finagle.journey.quickstart

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Duration, Future}

/*
* Run:
$ ./sbt 'run-main Client'
To obtain:
...
GET success: Response("HTTP/1.1 Status(200)")
...
*/
object Client extends App {

  println("Client.")

  val client: Service[http.Request, http.Response] = Http.newService("localhost:8080")

  val request = http.Request(http.Method.Get, "/")

  val response: Future[http.Response] = client(request)

  Await.result(response.onSuccess { rep: http.Response =>
    println("GET success: " + rep)
  })

}
