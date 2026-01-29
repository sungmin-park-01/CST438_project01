package com.cst338.cst438_p1
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("users")
class UserEntity {
    @PrimaryKey
    val username: String,
    val password: String
}