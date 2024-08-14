package cmd.client

import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import freemarker.cache.FileTemplateLoader
import java.io.StringWriter
import java.time.LocalDate
import java.io.File
import pkg.client.InitAdminCmd

fun main(args: Array<String>) {
    val admin = InitAdminCmd()
    admin.main(args)
}