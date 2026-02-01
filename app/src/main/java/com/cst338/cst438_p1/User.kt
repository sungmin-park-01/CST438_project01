package com.cst338.cst438_p1

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
@Entity(tableName = "users")
data class User(
    @PrimaryKey (autoGenerate = true)
    val uid: Int = 0,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "password") val password: String

)
@Entity(tableName = "jokes")
data class Joke(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "joke") val joke: String?
)
@Entity(tableName = "favorites")
data class Favorite(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "joke") val joke: String?
)