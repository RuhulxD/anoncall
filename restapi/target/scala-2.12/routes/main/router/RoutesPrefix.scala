
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ruhul/code/personal/sust/anoncall/restapi/conf/routes
// @DATE:Wed Jan 10 01:57:12 BDT 2018


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
