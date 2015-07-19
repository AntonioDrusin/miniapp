package com.irbis

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._
import MediaTypes._

class InvoiceServiceSpec extends Specification with Specs2RouteTest with InvoiceService {
  def actorRefFactory = system

  "InvoiceService" should {

    "return OK when getting an invoice" in {
      Get("/invoices/44") ~> route ~> check {
        status == OK
        responseAs[String] must contain("\"id\":44")
      }
    }

    "has Access-Control-Allow-Origin header" in {
      Get("/invoices/32") ~> route ~> check {
        header("Access-Control-Allow-Origin").head.value must be("*")
      }
    }

    "return OK when POSTing an invoice" in {
      Post("/invoices",HttpEntity(`application/json`, """{"description": "Jane", "id" : 42 }""")) ~> route ~> check {
        status == OK
        handled must beTrue
      }
    }

    // These are just standard tests.

    "leave GET requests to other paths unhandled" in {
      Get("/invoicess") ~> route ~> check {
        handled must beFalse
      }
    }

  }
}

