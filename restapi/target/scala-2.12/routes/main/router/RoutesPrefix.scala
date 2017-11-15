
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/ruhul/codes/AnonCall/restapi/conf/routes
// @DATE:Wed Nov 15 16:31:56 BDT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
