package com.malsolo.finagle.journey.serversandfilters

import com.twitter.finagle.{Http, Service, SimpleFilter, http}
import com.twitter.util._

class TimeoutFilter[Req, Rep](timeout: Duration, timer: Timer)
  extends SimpleFilter[Req, Rep] {

  def apply(request: Req, service: Service[Req, Rep]): Future[Rep] = {
    val res = service(request)
    res.within(timer, timeout)
  }
}

object ComposingFiltersApp extends App {
  val client = Http.newService("localhost:8282")
  val timeoutFilter = new TimeoutFilter[http.Request, http.Response](Duration.fromMilliseconds(1000), new JavaTimer(false))
  val clientWithTimeoutFilter = timeoutFilter andThen client

  val request = http.Request(http.Method.Get, "/")

  val response: Future[http.Response] = clientWithTimeoutFilter(request)

  Await.result(response.onSuccess { rep: http.Response =>
    println("GET success: " + rep)
  })

  Thread.sleep(250)
  println("HTTP Client. Done.")

}

