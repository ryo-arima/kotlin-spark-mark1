package pkg.client.controller

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import pkg.client.usecase.*
import pkg.config.*
import pkg.client.repository.*

class BootstrapUserCmdForAdmin: CliktCommand(name = "user", help="") {
    override fun run() {
        println("bootstrap user")
    }
}

class GetUsersCmdForAdmin: CliktCommand(name = "users", help="") {
    val name: String by option(help = "").default("Guest")
    val verbose: Boolean by option(help = "").flag()

    override fun run() {
        val appConf = NewApplicationConfig()
        val userReposiotryForPrivate = NewUserRepositoryForPrivate(appConf)
        val userUsecaseForAdmin = NewUserUsecaseForAdmin(userReposiotryForPrivate)
        userUsecaseForAdmin.get()
    }
}

class CreateUserCmdForAdmin: CliktCommand(name = "user", help="") {
    override fun run() {
        println("create user")
    }
}

class UpdateUserCmdForAdmin: CliktCommand(name = "user", help="") {
    override fun run() {
        println("update user")
    }
}

class DeleteUserCmdForAdmin: CliktCommand(name = "user", help="") {
    override fun run() {
        println("delete user")
    }
}

class GetUsersCmdForAppUser: CliktCommand(name = "users", help="") {
    override fun run() {
        println("get users")
    }
}

class CreateUserCmdForAppUser: CliktCommand(name = "user", help="") {
    override fun run() {
        println("create user")
    }
}

class UpdateUserCmdForAppUser: CliktCommand(name = "user", help="") {
    override fun run() {
        println("update user")
    }
}

class DeleteUserCmdForAppUser: CliktCommand(name = "user", help="") {
    override fun run() {
        println("delete user")
    }
}

class GetUsersCmdForAnonymous: CliktCommand(name = "users", help="") {
    override fun run() {
        println("get users")
    }
}

class CreateUserCmdForAnonymous: CliktCommand(name = "user", help="") {
    override fun run() {
        println("create user")
    }
}

