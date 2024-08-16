package pkg.client.repository

import pkg.config.*
import pkg.entity.request.*
import pkg.entity.response.*
import pkg.entity.model.*

interface UserReposiotryForPublic {
    val applicationConfig: ApplicationConfig
    fun create(userRequest: UserRequest): UserResponse
    fun get(userRequest: UserRequest): UserResponse
}

class UserReposiotryForPublicImpl(override val applicationConfig: ApplicationConfig): UserReposiotryForPublic {
    override fun get(userRequest: UserRequest): UserResponse {
        println("get user")
        return UserResponse( users = listOf(User(
            id = 1,
            uuid = "uuid",
            name = "user",
            email = "",
            password = "",
            createdAt = "2021-01-01",
            updatedAt = "2021-01-01",  
            deletedAt = "2021-01-01"
        )))
    }
    override fun create(userRequest: UserRequest): UserResponse {
        println("create user")
        return UserResponse( users = listOf(User(
            id = 1,
            uuid = "uuid",
            name = "user",
            email = "",
            password = "",
            createdAt = "2021-01-01",
            updatedAt = "2021-01-01",  
            deletedAt = "2021-01-01"
        )))
    }


}

fun NewUserRepositoryForPublic(config: ApplicationConfig): UserReposiotryForPublic {
    return UserReposiotryForPublicImpl(config)
}