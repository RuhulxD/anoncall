
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ruhul/code/personal/sust/anoncall/restapi/conf/routes
// @DATE:Wed Jan 10 01:57:12 BDT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers {

  // @LINE:10
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:17
  class ReverseApplicationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def addUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "anoncall/register")
    }
  
    // @LINE:18
    def makeCall(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "anoncall/makecall")
    }
  
    // @LINE:19
    def endCall(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "anoncall/endcall")
    }
  
    // @LINE:21
    def getTopics(): Call = {
    
      () match {
      
        // @LINE:21
        case ()  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "anoncall/getTopics")
      
      }
    
    }
  
    // @LINE:20
    def inCall(caller:String, callee:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "anoncall/incall/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("caller", caller)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("callee", callee)))
    }
  
  }

  // @LINE:13
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:8
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }


}
