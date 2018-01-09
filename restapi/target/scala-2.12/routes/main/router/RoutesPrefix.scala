
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/ruhul/codes/AnonCall/restapi/conf/routes
// @DATE:Tue Jan 09 18:52:03 BDT 2018


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
