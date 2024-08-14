package pkg.client

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import pkg.client.controller.*
import pkg.config.*

class AdminCmd: CliktCommand(name="admin",help="") {
    override fun run() {
        println("Admin")
    }
}

fun InitAdminCmd() : CliktCommand {
    val adminCmd = AdminCmd()
    val bootstrapCmd = BootstrapCmd()
    val getCmd = GetCmd()
    val createCmd = Create()
    val updateCmd = Update()
    val deleteCmd = Delete()
    bootstrapCmd.subcommands(BootstrapUserCmdForAdmin())
    getCmd.subcommands(GetUsersCmdForAdmin())
    createCmd.subcommands(CreateUserCmdForAdmin())
    updateCmd.subcommands(UpdateUserCmdForAdmin())
    deleteCmd.subcommands(DeleteUserCmdForAdmin())
    adminCmd.subcommands(bootstrapCmd,getCmd,createCmd,updateCmd,deleteCmd)
    return adminCmd
}