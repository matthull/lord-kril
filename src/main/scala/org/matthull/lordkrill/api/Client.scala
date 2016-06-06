package org.matthull.lordkrill.api

import org.joda.time.DateTime
import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._
import com.typesafe.config.{Config, ConfigFactory}

import java.text.SimpleDateFormat
import scalaj.http.Http

/**
  * Perform requests to Stockfighter API
  */
class Client(config: Config = ConfigFactory.load()) {

  val apiKey = config.getString("stockfighter.api_key")
  val account = config.getString("stockfighter.account")
  val venue = config.getString("stockfighter.venue")
  val defaultStock = config.getString("stockfighter.default_stock")

  val baseUrl = "https://api.stockfighter.io/ob/api"

  def url(uri: String) = baseUrl + uri

  def get(requestModel: ApiRequest)(implicit m: Manifest[requestModel.ResponseModel]): Either[Exception, requestModel.ResponseModel] = {
    val request = Http(url(requestModel.uri))
    val response = request.asString

    val status = parse(response.body).extract[ResponseStatus]

    status.ok match {
      case true => {
        val parsed = requestModel.entityPath match {
          case Some(path) => (parse(response.body) \ path)
          case None => parse(response.body)
        }

        Right(parsed.extract[requestModel.ResponseModel])
      }
      case false => Left(new Exception(parse(response.body).extract[ErrorApiResponse].error))
    }

  }

  def heartbeat(): Boolean = {
    get(HeartBeatRequest) match {
      case Right(_) => true
      case Left(_) => false
    }
  }

  def venueHeartbeat(): Boolean = {
    get(VenueHeartBeatRequest) match {
      case Right(_) => true
      case Left(_) => false
    }
  }

  implicit val formats = new DefaultFormats {
    override def dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  } ++ org.json4s.ext.JodaTimeSerializers.all

}
