package com.irbis

import spray.routing._
import spray.http._

// this trait defines our service behavior independently from the service actor
trait InvoiceService extends HttpService {

  val myRoute =
    path("invoice") {
        get {
          complete("list")
        } ~
        post {
          complete("create")
        }
    }
}
