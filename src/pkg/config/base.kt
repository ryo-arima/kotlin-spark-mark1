package pkg.config

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import freemarker.cache.FileTemplateLoader
import java.io.StringWriter
import java.time.LocalDate
import java.io.File

data class ApplicationConfig(
    val AppYaml: AppYaml,
    val TemplateEngineConfig: Configuration
)

data class AppYaml(
    val Application: Application,
    val Database: Database
)

data class Application(
    val Server: Server,
    val Client: Client
)

data class Server(
    val admin: Admin
)

data class Admin(
    val emails: List<String>
)

data class Client(
    val HomePath: String,
    val ServerEndpoint: String,
    val UserEmail: String,
    val UserPassword: String,
    val TemplatePath: String
)

data class Database(
    val host: String,
    val port: Int,
    val user: String,
    val password: String
)

fun NewApplicationConfig(): ApplicationConfig {
    val appYaml = NewAppYaml("etc/app.yaml")
    val templateEngineConfig = NewTemplateEngineConfig("bin/template")
    return ApplicationConfig(appYaml, templateEngineConfig)
}

fun NewAppYaml(configPath: String): AppYaml {
    val mapper = ObjectMapper(YAMLFactory()).apply {
        registerModule(KotlinModule())
    }

    val file = File(configPath)
    val appYaml: AppYaml = mapper.readValue(file)

    return appYaml
}

fun NewTemplateEngineConfig(templateDir: String): Configuration{
    val cfg = Configuration(Configuration.VERSION_2_3_31).apply {
        defaultEncoding = "UTF-8"
        templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER
        logTemplateExceptions = false
        wrapUncheckedExceptions = true
    }
    cfg.templateLoader = FileTemplateLoader(File(templateDir))

    return cfg
}

