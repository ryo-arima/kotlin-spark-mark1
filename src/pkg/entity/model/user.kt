package pkg.entity.model

public data class User(
    val id: Int,
    val uuid: String,
    val name: String,
    val email: String,
    val password: String,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String,
)