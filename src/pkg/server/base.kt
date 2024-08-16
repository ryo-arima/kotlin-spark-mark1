package pkg.server

import spark.Route
import spark.Spark.*

fun Server(args: Array<String>) {
    port(8080)
    InitRouter(args)
    init()
    awaitInitialization()
}