# play-sttp-examples

Some examples using sttp  "the Scala HTTP client you always wanted!"

https://sttp.readthedocs.io/

We also show the use of a Tor socks proxy

## To run

`sbt run`

GET     /                                                          controllers.AsyncHttpClientFutureController.index

GET     /asyncHttpClientFutureController/poke                      controllers.AsyncHttpClientFutureController.poke

GET     /asyncHttpClientFutureController/post                      controllers.AsyncHttpClientFutureController.post



GET     /httpURLConnectionController/poke                          controllers.HttpURLConnectionController.poke

GET     /httpURLConnectionController/post                          controllers.HttpURLConnectionController.post



Also some non play Apps, inside playpen

playpen.TryURLConnection
playpen.sttp.TryHttpURLConnectionBackend
playpen.sttp.TryAsyncHttpClientFutureBackend

## Tor

By default the socks proxy is not used, look inside application.conf

(localhost/9050 is for the Tor standalone socks proxy, 9150 is you rely on the Tor browser proxy) 

How to install Tor and create Tor hidden service on Windows

https://miloserdov.org/?p=1839

https://www.techwalla.com/articles/how-to-use-tor-proxy