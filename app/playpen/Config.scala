package playpen

import play.api.{Configuration, Environment}

object Config {

  private val config = Configuration.load(Environment.simple())

  private val info = config.get[Configuration]("info")

  val checkurl: String = info.get[String]("checkurl")

  val proxyEnabled: Boolean = info.get[Boolean]("proxyEnabled")

  val sockshost: String = info.get[String]("sockshost")
  val socksport: Int = info.get[Int]("socksport")

}
