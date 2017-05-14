import com.iqmsoft.scalatra.mongodb.controller._
import org.scalatra._
import javax.servlet.ServletContext
import com.iqmsoft.scalatra.mongodb.app._

import com.mongodb.casbah.{MongoClient, MongoClientURI}

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {

    val uri = MongoClientURI("mongodb://127.0.0.1:27017")
    val mongoClient = MongoClient(uri)
    val db = mongoClient("mtrdb")
    val collection = db("bookHist")

    context.mount(new MRScalatraServlet, "/")
    context.mount(new CalendarController(collection), "/main/*")
  }
}
