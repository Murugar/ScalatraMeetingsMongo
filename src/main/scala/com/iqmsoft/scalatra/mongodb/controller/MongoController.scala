package com.iqmsoft.scalatra.mongodb.controller

import com.iqmsoft.scalatra.mongodb.app.ScalatraMeetingRoomReservationStack
import com.mongodb.casbah.Imports._

/** DEPRECATED

class MongoController(mongoColl: MongoCollection) extends ScalatraMeetingRoomReservationStack{


  post("/insert") {
    val key = params("key")
    val value = params("value")
    val newObj = MongoDBObject(key -> value)
    mongoColl += newObj
  }



  get("/") {
    mongoColl.find()
    for { x <- mongoColl} yield {
      println(x)
      x
    }
  }

  get("/query/:key/:value") {
    val q = MongoDBObject(params("key") -> params("value"))
    for ( x <- mongoColl.findOne(q) ) yield x
  }
}


  */