package com.irbis

import spray.http.HttpHeaders.RawHeader
import spray.routing._
import spray.json._
import InvoiceJsonProtocol._

// this trait defines our service behavior independently from the service actor
trait InvoiceService extends HttpService {
  val route = respondWithHeader(RawHeader("Access-Control-Allow-Origin","*")) {
    path("invoices" / IntNumber) { id =>
      get {
        val invoice = Invoice(id, "SomeName")
        val result = invoice.toJson
        complete(result.toString)
      }
    } ~
      path("invoices") {
        post {
          entity(as[Invoice])(invoice =>
            complete(s"created : ${invoice.Description}")
          )
        }
      }
  }
}
