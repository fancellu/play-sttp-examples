package playpen.sttp

import playpen.Config._

import sttp.client.HttpURLConnectionBackend
import sttp.client.quick._

object TryHttpURLConnectionBackend extends App {

//  You can set socks proxy in env instead of setting backendOptions

//  System.setProperty("socksProxyHost", sockshost)
//  System.setProperty("socksProxyPort", socksport.toString)

  private implicit val backend = HttpURLConnectionBackend(options = Util.backendOptions)

  val out=quickRequest.get(uri"$checkurl").send()

  println(out)

  backend.close()

}
