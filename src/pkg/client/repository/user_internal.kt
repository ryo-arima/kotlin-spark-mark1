package pkg.client.repository

import pkg.config.*
import pkg.entity.request.*
import pkg.entity.response.*
import pkg.entity.model.*

interface UserReposiotryForInternal {
    val applicationConfig: ApplicationConfig
    fun create(userRequest: UserRequest): UserResponse
    fun update(userRequest: UserRequest): UserResponse
    fun delete(userRequest: UserRequest): UserResponse
}

class UserReposiotryForInternalImpl(override val applicationConfig: ApplicationConfig): UserReposiotryForInternal {
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

    override fun delete(userRequest: UserRequest): UserResponse {
        println("delete user")
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
}

fun NewUserRepositoryForInternal(config: ApplicationConfig): UserReposiotryForInternal {
    return UserReposiotryForInternalImpl(config)
}