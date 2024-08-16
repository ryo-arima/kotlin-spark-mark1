package pkg.server.usecase

import pkg.entity.model.User
import pkg.server.repository.UserRepository
import pkg.entity.request.UserRequest
import pkg.entity.response.UserResponse

interface UserUsecase {
    val userRepository: UserRepository
    fun get(userRequest: UserRequest): UserResponse
    fun create(userRequest: UserRequest): UserResponse
    fun update(userRequest: UserRequest): UserResponse
    fun delete(userRequest: UserRequest): UserResponse
}

class UserUsecaseImpl(userRepository: UserRepository): UserUsecase {
    override val userRepository: UserRepository = userRepository

    override fun get(userRequest: UserRequest): UserResponse {
        println("get user")
        return UserResponse(
            users = listOf(
                User(
                    id = 1,
                    uuid = "uuid",
                    name = "user",
                    email = "",
                    password = "",
                    createdAt = "2021-01-01",
                    updatedAt = "2021-01-01",
                    deletedAt = "2021-01-01"
                )
            )
        )
    }

    override fun create(userRequest: UserRequest): UserResponse {
        println("create user")
        return UserResponse(
            users = listOf(
                User(
                    id = 1,
                    uuid = "uuid",
                    name = "user",
                    email = "",
                    password = "",
                    createdAt = "2021-01-01",
                    updatedAt = "2021-01-01",
                    deletedAt = "2021-01-01"
                )
            )
        )
    }

    override fun update(userRequest: UserRequest): UserResponse {
        println("update user")
        return UserResponse(
            users = listOf(
                User(
                    id = 1,
                    uuid = "uuid",
                    name = "user",
                    email = "",
                    password = "",
                    createdAt = "2021-01-01",
                    updatedAt = "2021-01-01",
                    deletedAt = "2021-01-01"
                )
            ) 
        )
    }

    override fun delete(userRequest: UserRequest): UserResponse {
        println("delete user")
        return UserResponse(
            users = listOf(
                User(
                    id = 1,
                    uuid = "uuid",
                    name = "user",
                    email = "",
                    password = "",
                    createdAt = "2021-01-01",
                    updatedAt = "2021-01-01",
                    deletedAt = "2021-01-01"
                )
            )
        )
    }

}

fun NewUserUsecase(userRepository: UserRepository): UserUsecase {
    return UserUsecaseImpl(userRepository)
}
