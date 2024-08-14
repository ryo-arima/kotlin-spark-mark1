package pkg.server

import spark.Route
import spark.Spark.*
import pkg.server.controller.*
import pkg.server.usecase.*
import pkg.server.repository.*
import pkg.config.*

fun InitRouter(args: Array<String>){

    val appConf = NewApplicationConfig()
    val userReposiotry = NewUserRepository(appConf)
    val userUsecase = NewUserUsecase(userReposiotry)
    val userController = NewUserController(userUsecase)
    //before("/api/private/*") { req, res ->
    //    val token = req.headers("Authorization")
    //    if (token == null || token != "valid_token") {
    //        halt(401, "Unauthorized")  // 認証失敗時には401エラーを返す
    //    }
    //}

    path("/api/private") {
        get("/users", Route { req, res -> userController.GetUsersForPrivate(req, res) })
        post("/user", Route { req, res -> userController.CreateUserForPrivate(req, res) })
        put("/user", Route { req, res -> userController.UpdateUserForPrivate(req, res) })
        delete("/user", Route { req, res -> userController.DeleteUserForPrivate(req, res) })
    }
    path("/api/internal") {
        get("/users", Route { req, res -> userController.GetUsersForInternal(req, res) })
        post("/user", Route { req, res -> userController.CreateUserForInternal(req, res) })
        put("/user", Route { req, res -> userController.UpdateUserForInternal(req, res) })
        delete("/user", Route { req, res -> userController.DeleteUserForInternal(req, res) })
    }
    path("/api/public") {
        get("/users", Route { req, res -> userController.GetUsersForPublic(req, res) })
        post("/user", Route { req, res -> userController.CreateUserForPublic(req, res) })
    }

}