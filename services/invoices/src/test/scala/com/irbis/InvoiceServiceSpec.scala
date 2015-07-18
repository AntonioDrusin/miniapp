package com.irbis

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._

class InvoiceServiceSpec extends Specification with Specs2RouteTest with InvoiceService {
  def actorRefFactory = system

  "Invoice" should {

    "return OK when getting an invoice" in {
      Get("/invoice") ~> myRoute ~> check {
        status == OK
      }
    }

    "return OK when POSTing an invoice" in {
      Post("/invoice") ~> myRoute ~> check {
        status == OK
        handled must beTrue
      }
    }

    // These are just standard tests.

    "leave GET requests to other paths unhandled" in {
      Get("/invoices") ~> myRoute ~> check {
        handled must beFalse
      }
    }

  }
}
