package com.malsolo.finagle.journey.quickstart

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, Response}
import com.twitter.util.Await

/**
$ curl --dump-header - --header "Host: www.wikia.com" localhost:8181
HTTP/1.1 301 Moved Permanently
Cache-Control: private, s-maxage=0, max-age=0, must-revalidate
Location: http://www.wikia.com/fandom
*/
object Proxy extends App {
  val  client: Service[Request, Response] = Http.newService("www.wikia.com:80")

  val server = Http.serve(":8181", client)

  Await.ready(server)
}
