package pkg.client.usecase

import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import freemarker.cache.FileTemplateLoader
import java.io.StringWriter
import java.time.LocalDate
import java.io.File
import pkg.client.repository.*

interface UserUsecase {
    fun bootstrap()
    fun get()
    fun create() 
    fun update()
    fun delete()
}

class UserUsecaseImpl(userReposiotry: UserReposiotry): UserUsecase {
    val userReposiotry: UserReposiotry = userReposiotry

    override fun bootstrap() {
        println("bootstrap user")
    } 

    override fun get() {
        println("get user")
        println(userReposiotry.applicationConfig)
    }

    override fun create() {
        println("create user")
    }


    override fun update() {
        println("update user")
    }

    override fun delete() {
        println("delete user")
    }

}

fun NewUserUsecase(userReposiotry: UserReposiotry): UserUsecase {
    return UserUsecaseImpl(userReposiotry)
}