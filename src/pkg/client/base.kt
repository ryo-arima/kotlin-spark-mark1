package pkg.client

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import pkg.client.controller.*

class BootstrapCmd: CliktCommand(name = "bootstrap", help="") {
    override fun run() {
        println("Bootstrap")
    }
}

class GetCmd: CliktCommand(name = "get", help="") {
    override fun run() {
        println("Get")
    }
}

class Create: CliktCommand(name = "create", help="") {
    override fun run() {
        println("Create")
    }
}

class Update: CliktCommand(name = "update", help="") {
    override fun run() {
        println("Update")
    }
}

class Delete: CliktCommand(name = "delete", help="") {
    override fun run() {
        println("Delete")
    }
}