package playpen.sttp

import playpen.Config.{proxyEnabled, sockshost, socksport}
import sttp.client.SttpBackendOptions

object Util {
  val backendOptions: SttpBackendOptions =if (proxyEnabled) SttpBackendOptions.socksProxy(sockshost, socksport) else SttpBackendOptions.Default
}
