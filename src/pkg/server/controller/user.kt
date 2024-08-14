package pkg.server.controller

import spark.Route
import spark.Spark.*
import pkg.server.usecase.*

interface UserController {
    val userUsecase: UserUsecase
    fun GetUsersForPrivate(req: spark.Request, res: spark.Response): Any
    fun CreateUserForPrivate(req: spark.Request, res: spark.Response): Any
    fun UpdateUserForPrivate(req: spark.Request, res: spark.Response): Any
    fun DeleteUserForPrivate(req: spark.Request, res: spark.Response): Any
    fun GetUsersForInternal(req: spark.Request, res: spark.Response): Any
    fun CreateUserForInternal(req: spark.Request, res: spark.Response): Any
    fun UpdateUserForInternal(req: spark.Request, res: spark.Response): Any
    fun DeleteUserForInternal(req: spark.Request, res: spark.Response): Any
    fun GetUsersForPublic(req: spark.Request, res: spark.Response): Any
    fun CreateUserForPublic(req: spark.Request, res: spark.Response): Any
}

class UserControllerImpl(override val userUsecase: UserUsecase): UserController {
    override fun GetUsersForPrivate(req: spark.Request, res: spark.Response): Any {
        return "Hello, World!"
    }

    override fun CreateUserForPrivate(req: spark.Request, res: spark.Response): Any {
        return "Hello, World!"
    }

    override fun UpdateUserForPrivate(req: spark.Request, res: spark.Response): Any {
        return "Hello, World!"
    }

    override fun DeleteUserForPrivate(req: spark.Request, res: spark.Response): Any {
        return "Hello, World!"
    }

    override fun GetUsersForInternal(req: spark.Request, res: spark.Response): Any {
        return "Hello, World!"
    }

    override fun CreateUserForInternal(req: spark.Request, res: spark.Response): Any {
        return "Hello, World!"
    }

    override fun UpdateUserForInternal(req: spark.Request, res: spark.Response): Any {
        return "Hello, World!"
    }

    override fun DeleteUserForInternal(req: spark.Request, res: spark.Response): Any {
        return "Hello, World!"
    }

    override fun GetUsersForPublic(req: spark.Request, res: spark.Response): Any {
        return "Hello, World!"
    }

    override fun CreateUserForPublic(req: spark.Request, res: spark.Response): Any {
        return "Hello, World!"
    }
}

fun NewUserController(userUsecase: UserUsecase): UserController {
    return UserControllerImpl(userUsecase)
}
