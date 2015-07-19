package com.irbis

import spray.httpx.SprayJsonSupport
import spray.json.DefaultJsonProtocol

import scala.reflect.ClassTag

case class Invoice (  Id : Long,  Description : String)

object InvoiceJsonProtocol extends DefaultJsonProtocol with SprayJsonSupport{
  implicit val invoiceFormat = jsonFormat2(Invoice)

  override protected def extractFieldNames(classTag: ClassTag[_]) : Array[String]  = {
    super.extractFieldNames(classTag).map( name => name.patch(0,Seq(name.head.toLower),1))
  }
}
