
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ruhul/code/personal/sust/anoncall/restapi/conf/routes
// @DATE:Wed Jan 10 01:57:12 BDT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  CountController_3: controllers.CountController,
  // @LINE:10
  AsyncController_1: controllers.AsyncController,
  // @LINE:13
  Assets_0: controllers.Assets,
  // @LINE:17
  ApplicationController_2: controllers.ApplicationController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    CountController_3: controllers.CountController,
    // @LINE:10
    AsyncController_1: controllers.AsyncController,
    // @LINE:13
    Assets_0: controllers.Assets,
    // @LINE:17
    ApplicationController_2: controllers.ApplicationController
  ) = this(errorHandler, CountController_3, AsyncController_1, Assets_0, ApplicationController_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, CountController_3, AsyncController_1, Assets_0, ApplicationController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """anoncall/register""", """controllers.ApplicationController.addUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """anoncall/makecall""", """controllers.ApplicationController.makeCall"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """anoncall/endcall""", """controllers.ApplicationController.endCall"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """anoncall/incall/""" + "$" + """caller<[^/]+>/""" + "$" + """callee<[^/]+>""", """controllers.ApplicationController.inCall(caller:String, callee:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """anoncall/getTopics""", """controllers.ApplicationController.getTopics"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """anoncall/getTopics/""", """controllers.ApplicationController.getTopics"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:8
  private[this] lazy val controllers_CountController_count0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count0_invoker = createInvoker(
    CountController_3.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing a sample home page
GET     /                           controllers.HomeController.index
 An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AsyncController_message1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message1_invoker = createInvoker(
    AsyncController_1.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned2_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ApplicationController_addUser3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("anoncall/register")))
  )
  private[this] lazy val controllers_ApplicationController_addUser3_invoker = createInvoker(
    ApplicationController_2.addUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "addUser",
      Nil,
      "POST",
      this.prefix + """anoncall/register""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_ApplicationController_makeCall4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("anoncall/makecall")))
  )
  private[this] lazy val controllers_ApplicationController_makeCall4_invoker = createInvoker(
    ApplicationController_2.makeCall,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "makeCall",
      Nil,
      "POST",
      this.prefix + """anoncall/makecall""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_ApplicationController_endCall5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("anoncall/endcall")))
  )
  private[this] lazy val controllers_ApplicationController_endCall5_invoker = createInvoker(
    ApplicationController_2.endCall,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "endCall",
      Nil,
      "POST",
      this.prefix + """anoncall/endcall""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_ApplicationController_inCall6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("anoncall/incall/"), DynamicPart("caller", """[^/]+""",true), StaticPart("/"), DynamicPart("callee", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ApplicationController_inCall6_invoker = createInvoker(
    ApplicationController_2.inCall(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "inCall",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """anoncall/incall/""" + "$" + """caller<[^/]+>/""" + "$" + """callee<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_ApplicationController_getTopics7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("anoncall/getTopics")))
  )
  private[this] lazy val controllers_ApplicationController_getTopics7_invoker = createInvoker(
    ApplicationController_2.getTopics,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "getTopics",
      Nil,
      "GET",
      this.prefix + """anoncall/getTopics""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_ApplicationController_getTopics8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("anoncall/getTopics/")))
  )
  private[this] lazy val controllers_ApplicationController_getTopics8_invoker = createInvoker(
    ApplicationController_2.getTopics,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "getTopics",
      Nil,
      "GET",
      this.prefix + """anoncall/getTopics/""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_CountController_count0_route(params@_) =>
      call { 
        controllers_CountController_count0_invoker.call(CountController_3.count)
      }
  
    // @LINE:10
    case controllers_AsyncController_message1_route(params@_) =>
      call { 
        controllers_AsyncController_message1_invoker.call(AsyncController_1.message)
      }
  
    // @LINE:13
    case controllers_Assets_versioned2_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned2_invoker.call(Assets_0.versioned(path, file))
      }
  
    // @LINE:17
    case controllers_ApplicationController_addUser3_route(params@_) =>
      call { 
        controllers_ApplicationController_addUser3_invoker.call(ApplicationController_2.addUser)
      }
  
    // @LINE:18
    case controllers_ApplicationController_makeCall4_route(params@_) =>
      call { 
        controllers_ApplicationController_makeCall4_invoker.call(ApplicationController_2.makeCall)
      }
  
    // @LINE:19
    case controllers_ApplicationController_endCall5_route(params@_) =>
      call { 
        controllers_ApplicationController_endCall5_invoker.call(ApplicationController_2.endCall)
      }
  
    // @LINE:20
    case controllers_ApplicationController_inCall6_route(params@_) =>
      call(params.fromPath[String]("caller", None), params.fromPath[String]("callee", None)) { (caller, callee) =>
        controllers_ApplicationController_inCall6_invoker.call(ApplicationController_2.inCall(caller, callee))
      }
  
    // @LINE:21
    case controllers_ApplicationController_getTopics7_route(params@_) =>
      call { 
        controllers_ApplicationController_getTopics7_invoker.call(ApplicationController_2.getTopics)
      }
  
    // @LINE:22
    case controllers_ApplicationController_getTopics8_route(params@_) =>
      call { 
        controllers_ApplicationController_getTopics8_invoker.call(ApplicationController_2.getTopics)
      }
  }
}
