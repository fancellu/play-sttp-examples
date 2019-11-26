package controllers

import javax.inject._
import play.api.mvc._
import playpen.Config
import sttp.client.Response

import scala.concurrent.Future
import sttp.client.quick._

import scala.concurrent.ExecutionContext
import Config._
import playpen.sttp.Util
import sttp.client.asynchttpclient.future.AsyncHttpClientFutureBackend

@Singleton
class AsyncHttpClientFutureController @Inject()(implicit ec: ExecutionContext, cc: ControllerComponents) extends AbstractController(cc) {

  private implicit val backend = AsyncHttpClientFutureBackend(options = Util.backendOptions)

  def index=Action(Ok("Hello"))

  def poke = Action.async { request=>

    val outF: Future[Response[String]] =quickRequest.get(uri"$checkurl").send()

    outF.map(resp=>new Status(resp.code.code)(s"proxyEnabled=$proxyEnabled<BR/>"+resp.body).as(resp.contentType.getOrElse("")))
  }

  def post = Action.async { request=>

    val signup = Some("yes")

    val request = basicRequest
      // send the body as form data (x-www-form-urlencoded)
      .body(Map("name" -> "JohnAsync", "surname" -> "doeAsync"))
      .post(uri"https://httpbin.org/post?signup=$signup")

    val outF: Future[Response[Either[String, String]]] = request.send()

    outF.map(resp=>new Status(resp.code.code)(resp.body.merge).as(resp.contentType.getOrElse("")))
  }
}
