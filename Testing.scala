
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Testing extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://petstore.octoperf.com")
    .inferHtmlResources()
    .acceptHeader("image/avif,image/webp,*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/109.0")
  
  private val headers_0 = Map(
  		"Accept" -> "application/json",
  		"Content-Type" -> "application/json",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "cross-site"
  )
  
  private val headers_2 = Map(
  		"Origin" -> "null",
  		"Sec-Fetch-Dest" -> "image",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "cross-site"
  )
  
  private val headers_10 = Map(
  		"Accept" -> "*/*",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "cross-site"
  )
  
  private val headers_16 = Map(
  		"Accept" -> "*/*",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "no-cors",
  		"Sec-Fetch-Site" -> "cross-site"
  )
  
  private val headers_19 = Map(
  		"Sec-Fetch-Dest" -> "image",
  		"Sec-Fetch-Mode" -> "no-cors",
  		"Sec-Fetch-Site" -> "cross-site"
  )
  
  private val headers_21 = Map(
  		"If-None-Match" -> """"7df3ff7cd3a09798e8e42873bdff09be8814b7f9"""",
  		"Origin" -> "null",
  		"Sec-Fetch-Dest" -> "image",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "cross-site"
  )
  
  private val headers_22 = Map(
  		"If-None-Match" -> """"18b18991f5e33f7a34a8b043924ac2d5bfa766d5"""",
  		"Origin" -> "null",
  		"Sec-Fetch-Dest" -> "image",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "cross-site"
  )
  
  private val headers_23 = Map(
  		"If-None-Match" -> """"889007ca20352d06140d0362ab72b3074f2a2376"""",
  		"Origin" -> "null",
  		"Sec-Fetch-Dest" -> "image",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "cross-site"
  )
  
  private val headers_24 = Map(
  		"If-None-Match" -> """"4acf43dba4ed4ce768982e278ea67980bcf70eda"""",
  		"Origin" -> "null",
  		"Sec-Fetch-Dest" -> "image",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "cross-site"
  )
  
  private val headers_25 = Map(
  		"If-None-Match" -> """"55a03270778c91a2ef8e7d085e4456c3884d3073"""",
  		"Origin" -> "null",
  		"Sec-Fetch-Dest" -> "image",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "cross-site"
  )
  
  private val headers_26 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1"
  )
  
  private val headers_29 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8",
  		"Origin" -> "https://petstore.octoperf.com",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1"
  )
  


  private val scn = scenario("Testing")


    .exec(
      http("Launch")
        .get("/actions/Account.action;jsessionid=6FC7CED31C42907BA24BB3977CE74CEC?signonForm=")
        .headers(headers_26)
    )
    .pause(6)
    .exec(
      http("Login")
        .post("/actions/Account.action")
        .headers(headers_29)
        .formParam("username", "subham")
        .formParam("password", "subham")
        .formParam("signon", "Login")
        .formParam("_sourcePage", "vAUdvokJznYbVG8eyciOISCqmnyEbSipakQReCZEwdYR0uV4HUjbImMM9iutGOmt63_0iDkEeJS-oJDHl6BRpoYKXLztiFTqwp6a25JXUxI=")
        .formParam("__fp", "Oa2lepV0WgRhFQu5Ejxzs-xDVZAMC3t-JmoKFnh2uxrE7jPcufP7Plm1sSeWcuiv")
        .check(substring("Welcome subham!").exists)
    )
    .pause(3)
    .exec(
      http("Select_Category_ID")
        .get("/actions/Catalog.action?viewCategory=&categoryId=FISH")
        .headers(headers_26)
    )
    .pause(2)
    .exec(
      http("Select_Product_ID")
        .get("/actions/Catalog.action?viewProduct=&productId=FI-SW-01")
        .headers(headers_26)
    )
    .pause(2)
    .exec(
      http("Select_Item_ID")
        .get("/actions/Catalog.action?viewItem=&itemId=EST-1")
        .headers(headers_26)
    )
    .pause(2)
    .exec(
      http("AddtoCart")
        .get("/actions/Cart.action?addItemToCart=&workingItemId=EST-1")
        .headers(headers_26)
    )
    .pause(2)
    .exec(
      http("Confirm_Order")
        .get("/actions/Order.action?newOrderForm=")
        .headers(headers_26)
    )
    .pause(3)
    .exec(
      http("Proceed_to_Pay")
        .post("/actions/Order.action")
        .headers(headers_29)
        .formParam("order.cardType", "Visa")
        .formParam("order.creditCard", "999 9999 9999 9999")
        .formParam("order.expiryDate", "12/03")
        .formParam("order.billToFirstName", "subham")
        .formParam("order.billToLastName", "subham")
        .formParam("order.billAddress1", "subham")
        .formParam("order.billAddress2", "subham")
        .formParam("order.billCity", "subham")
        .formParam("order.billState", "subham")
        .formParam("order.billZip", "subham")
        .formParam("order.billCountry", "subham")
        .formParam("newOrder", "Continue")
        .formParam("_sourcePage", "NZHlv9Yz5EiRP7-C2euKznIuMUvHDo1kDYnofMC9Ko2ZKrS11WyH-AlGXP7frKHTDaAFWLsKh3M6Aw70Pcanb_t1f5DvAFrRpUkqn9y9JwQ=")
        .formParam("__fp", "_nQ3PS5LPBgtXLMMbuNe3c3upNR4Ajl7cpSo_mndFgzugEeG_rb6ayYD8flU4An2MF_sG_sl11bvYziX2nlkn1rY6pOsXqLjQ82LHk-Y1AfxIq6CIANkvQ==")
    )
    .pause(2)
    .exec(
      http("Place_Order")
        .get("/actions/Order.action?newOrder=&confirmed=true")
        .check(substring("Thank you, your order has been submitted.").exists)
        .check(regex("""Order #([0-9]*)""").findRandom.saveAs("OrderID"))
        .headers(headers_26)
    )

		.exec(session => {
			scala.tools.nsc.io.File("C:/gatling-charts-highcharts-bundle-3.9.0-bundle/gatling-charts-highcharts-bundle-3.9.0/results/OrderID1.csv").appendAll(session("OrderID").as[String] + "\n")
			session
		}
		)
    .pause(4)
    .exec(
      http("Sign_Off")
        .get("/actions/Account.action?signoff=")
        .headers(headers_26)
    )

	setUp(scn.inject(atOnceUsers(50))).protocols(httpProtocol)

	//setUp(scn.inject(constantConcurrentUsers(5) during(5 minutes))
		//.protocols(httpProtocol))

}
