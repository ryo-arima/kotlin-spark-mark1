package pkg.client.repository

import pkg.config.*
import pkg.entity.request.*
import pkg.entity.response.*
import pkg.entity.model.*

interface UserReposiotryForPrivate {
    val applicationConfig: ApplicationConfig
    fun bootstrap(userModel: User)
    fun get(userRequest: UserRequest): UserResponse
    fun create(userRequest: UserRequest): UserResponse
    fun update(userRequest: UserRequest): UserResponse
    fun delete(userRequest: UserRequest): UserResponse
}

class UserReposiotryForPrivateImpl(override val applicationConfig: ApplicationConfig): UserReposiotryForPrivate {
    override fun bootstrap(userModel: User) {
        println("bootstrap user")
    }

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
        return UserResponse(users = listOf(User(
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

    override fun update(userRequest: UserRequest): UserResponse {
        println("update user")
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

    override fun delete(userRequest: UserRequest): UserResponse {
        println("delete user")
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

fun NewUserRepositoryForPrivate(config: ApplicationConfig): UserReposiotryForPrivate {
    return UserReposiotryForPrivateImpl(config)
}