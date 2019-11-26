package controllers

import javax.inject._
import play.api.mvc._
import playpen.Config._
import playpen.sttp.Util
import sttp.client.{HttpURLConnectionBackend, Identity, Response}
import sttp.client.quick._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HttpURLConnectionController @Inject()(implicit ec: ExecutionContext, cc: ControllerComponents) extends AbstractController(cc) {

  private implicit val backend = HttpURLConnectionBackend(options = Util.backendOptions)

  def index=Action(Ok("Hello"))

  def poke = Action { request=>

    val resp=quickRequest.get(uri"$checkurl").send()

    new Status(resp.code.code)(s"proxyEnabled=$proxyEnabled"+resp.body).as(resp.contentType.getOrElse(""))
  }

  def post = Action { request=>

    val signup = Some("yes")

    val request = basicRequest
      // send the body as form data (x-www-form-urlencoded)
      .body(Map("name" -> "John", "surname" -> "doe"))
      .post(uri"https://httpbin.org/post?signup=$signup")

    val resp: Identity[Response[Either[String, String]]] = request.send()

    new Status(resp.code.code)(resp.body.merge).as(resp.contentType.getOrElse(""))
  }
}
