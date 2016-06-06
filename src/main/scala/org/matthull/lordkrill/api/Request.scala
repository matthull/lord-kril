package org.matthull.lordkrill.api

import com.typesafe.config.ConfigFactory

trait ApiRequest {

  type ResponseModel

  val uri: String

  val entityPath: Option[String] = None

  val requiresAuth: Boolean = false

}
case object HeartBeatRequest extends ApiRequest {

  type ResponseModel = ResponseStatus

  val uri = "/heartbeat"

}

case object VenueHeartBeatRequest extends ApiRequest {

  type ResponseModel = ResponseStatus

  val venue = ConfigFactory.load().getString("stockfighter.venue")

  val uri = s"/venues/$venue/heartbeat"

}

case object VenueStocksRequest extends ApiRequest {

  type ResponseModel = List[Stock]

  val venue = ConfigFactory.load().getString("stockfighter.venue")

  val uri = s"/venues/$venue/stocks"

  override val entityPath = Some("symbols")

}
