package cmd.client

import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import freemarker.cache.FileTemplateLoader
import java.io.StringWriter
import java.time.LocalDate
import java.io.File

fun main() {
    println("Hello, World!")
    val currentDir = System.getProperty("user.dir")

    println("Current directory: $currentDir")
    val cfg = Configuration(Configuration.VERSION_2_3_31).apply {
        defaultEncoding = "UTF-8"
        templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER
        logTemplateExceptions = false
        wrapUncheckedExceptions = true
    }
    cfg.templateLoader = FileTemplateLoader(File("$currentDir/bin/template"))

    // 2. データモデルを作成する
    val dataModel = mapOf(
        "name" to "Kotlin User",
        "date" to LocalDate.now().toString(),
        "items" to listOf("Item 1", "Item 2", "Item 3")
    )

    val template = cfg.getTemplate("message.template")
    val output = StringWriter()
    template.process(dataModel, output)

    println(output.toString())
}