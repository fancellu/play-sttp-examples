package playpen

import java.net.{InetSocketAddress, URL}
import java.net.Proxy
import Config._

object TryURLConnection extends App {

  val proxy = if (proxyEnabled) new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(sockshost, socksport)) else Proxy.NO_PROXY
  val url = new URL(checkurl)

  val is=url.openConnection(proxy).getInputStream

  val string=scala.io.Source.fromInputStream(is).mkString
  is.close()
  println(string)

}
