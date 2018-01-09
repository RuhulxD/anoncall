
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ruhul/code/personal/sust/anoncall/restapi/conf/routes
// @DATE:Wed Jan 10 01:57:12 BDT 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers.javascript {

  // @LINE:10
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseApplicationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def addUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApplicationController.addUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "anoncall/register"})
        }
      """
    )
  
    // @LINE:18
    def makeCall: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApplicationController.makeCall",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "anoncall/makecall"})
        }
      """
    )
  
    // @LINE:19
    def endCall: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApplicationController.endCall",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "anoncall/endcall"})
        }
      """
    )
  
    // @LINE:21
    def getTopics: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApplicationController.getTopics",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anoncall/getTopics"})
          }
        
        }
      """
    )
  
    // @LINE:20
    def inCall: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApplicationController.inCall",
      """
        function(caller0,callee1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "anoncall/incall/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("caller", caller0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("callee", callee1))})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseCountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountController.count",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count"})
        }
      """
    )
  
  }


}
