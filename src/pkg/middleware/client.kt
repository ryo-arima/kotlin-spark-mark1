package pkg.middleware

import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import freemarker.cache.FileTemplateLoader
import java.io.StringWriter
import java.time.LocalDate
import java.io.File

fun Output(cfg: Configuration, dataModel: Map<String, Any>, templateName: String) {
    val template = cfg.getTemplate(templateName)
    val output = StringWriter()
    template.process(dataModel, output)
    println(output.toString())
}