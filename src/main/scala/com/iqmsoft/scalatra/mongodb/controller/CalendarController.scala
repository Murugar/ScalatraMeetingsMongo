package com.iqmsoft.scalatra.mongodb.controller

import com.iqmsoft.scalatra.mongodb.app.ScalatraMeetingRoomReservationStack
import com.mongodb.casbah.Imports._
import org.scalatra.Ok
import org.slf4j.{Logger, LoggerFactory}

import scala.util.parsing.json.JSON


//RequestMapping -> /calendar/*
class CalendarController(mongoColl: MongoCollection) extends ScalatraMeetingRoomReservationStack{

  val logger: Logger = LoggerFactory.getLogger(getClass)

  get("/"){
    logger.info("[Aaron Logger] /calendar loaded...")
    contentType="text/html"
    ssp("/calendar", "title"->"")
  }


  post("/book"){

    val bokPrsNm, bokMemo, useDtTm, useStTm, useEndTm:String = null

    // Insert into MongoDB collection 'bookHist'
    mongoColl += MongoDBObject(
      "bokPrsNm" -> params("bokPrsNm")
      ,"bokMemo" -> params("bokMemo")
      ,"useDtTm" -> params("useDtTm")
      ,"useStTm" -> params("useStTm")
      ,"useEndTm" -> params("useEndTm")
      ,"delYn" -> "N"
    )

    Ok("Success")
  }

  get("/book"){
    val json = "[%s]".format( mongoColl.find().toList.mkString(",") )
    response.setContentType("application/json")
    Ok(json)
  }
}
