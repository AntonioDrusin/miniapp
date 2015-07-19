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
      Get("/invoice/44") ~> route ~> check {
        status == OK
        responseAs[String] must contain("\"id\":44")
      }
    }

    "return OK when POSTing an invoice" in {
      Post("/invoice",HttpEntity(`application/json`, """{"description": "Jane", "id" : 42 }""")) ~> route ~> check {
        status == OK
        handled must beTrue
      }
    }

    // These are just standard tests.

    "leave GET requests to other paths unhandled" in {
      Get("/invoices") ~> route ~> check {
        handled must beFalse
      }
    }

  }
}

