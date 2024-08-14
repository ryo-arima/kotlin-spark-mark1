package pkg.server.repository

import pkg.entity.model.User
import pkg.config.*

interface UserRepository {
    val applicationConfig: ApplicationConfig
    fun find(): List<User>
    fun create(user: User): User
    fun update(user: User): User
    fun delete(user: User): User
}

class UserRepositoryImpl(override val applicationConfig: ApplicationConfig): UserRepository {
    override fun find(): List<User> {
        println("find user")
        return listOf(
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
    }

    override fun create(user: User): User {
        println("create user")
        return user
    }

    override fun update(user: User): User {
        println("update user")
        return user
    }

    override fun delete(user: User): User {
        println("delete user")
        return user
    }
}

fun NewUserRepository(applicationConfig: ApplicationConfig): UserRepository {
    return UserRepositoryImpl(applicationConfig)
}