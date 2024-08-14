package pkg.client.repository

import pkg.config.*

interface UserReposiotry {
    val applicationConfig: ApplicationConfig
    fun bootstrap()
    fun create() 
    fun get()
    fun update()
    fun delete()
}

class UserReposiotryImpl(override val applicationConfig: ApplicationConfig): UserReposiotry {

    override fun bootstrap() {
        println("bootstrap user")
    } 
   
    override fun get() {
        println(applicationConfig)
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

fun NewUserRepository(config: ApplicationConfig): UserReposiotry {
    return UserReposiotryImpl(config)
}