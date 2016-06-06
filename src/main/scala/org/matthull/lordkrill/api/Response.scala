package org.matthull.lordkrill.api

/**
  * Response classes for Stockfighter API
  */

trait ApiResponse

case class ResponseStatus(ok: Boolean) extends ApiResponse

case class ErrorApiResponse(ok: Boolean, error: String) extends ApiResponse

case class Stock(name: String, symbol: String) extends ApiResponse
