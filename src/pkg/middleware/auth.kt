package pkg.middleware

import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import freemarker.cache.FileTemplateLoader
import java.io.StringWriter
import java.time.LocalDate
import java.io.File
import spark.Spark.*


fun ForPrivate(req: spark.Request, res: spark.Response){
    val token = req.headers("Authorization")
    if (token == null || token != "valid_token") {
        halt(401, "Unauthorized")
    }
}

fun ForInternal(req: spark.Request, res: spark.Response){
    val token = req.headers("Authorization")
    if (token == null || token != "valid_token") {
        halt(401, "Unauthorized")
    }
}

fun ForPublic(req: spark.Request, res: spark.Response){
}