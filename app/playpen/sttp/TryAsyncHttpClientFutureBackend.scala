package playpen.sttp

import sttp.client.SttpBackendOptions
import sttp.client.asynchttpclient.future.AsyncHttpClientFutureBackend
import sttp.client.quick.quickRequest
import sttp.client._

import scala.concurrent.duration._
import playpen.Config._

import scala.concurrent.Await

object TryAsyncHttpClientFutureBackend extends App {

  val backendOptions=SttpBackendOptions.socksProxy(sockshost, socksport)

  private implicit val backend = AsyncHttpClientFutureBackend(options = Util.backendOptions)

  val outF=quickRequest.get(uri"$checkurl").send()

  val out=Await.result(outF, 10.seconds)

  println(out)

  backend.close()

}
