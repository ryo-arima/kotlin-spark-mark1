package pkg.client.usecase

import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import freemarker.cache.FileTemplateLoader
import java.io.StringWriter
import java.time.LocalDate
import java.io.File
import pkg.client.repository.*
import pkg.middleware.*
import pkg.entity.response.*
import pkg.entity.request.*
import pkg.entity.model.*

interface UserUsecaseForAdmin {
    fun bootstrap()
    fun get()
    fun create() 
    fun update()
    fun delete()
}

class UserUsecaseForAdminImpl(userReposiotryForPrivate: UserReposiotryForPrivate): UserUsecaseForAdmin {
    val userReposiotryForPrivate: UserReposiotryForPrivate = userReposiotryForPrivate

    override fun bootstrap() {
        println("bootstrap user")
    } 

    override fun get(){
        println("get user")
        val cfg = userReposiotryForPrivate.applicationConfig.TemplateEngineConfig
        var userResponse: UserResponse = userReposiotryForPrivate.get(UserRequest( user = User(
            id = 1,
            uuid = "uuid",
            name = "user",
            email = "",
            password = "",
            createdAt = "2021-01-01",
            updatedAt = "2021-01-01",  
            deletedAt = "2021-01-01"
        )))
        Output(cfg, mapOf("name" to "user------!"), "get_users.template")
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

fun NewUserUsecaseForAdmin(userReposiotryForPrivate: UserReposiotryForPrivate): UserUsecaseForAdmin {
    return UserUsecaseForAdminImpl(userReposiotryForPrivate)
}