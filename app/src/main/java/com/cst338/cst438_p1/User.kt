package com.cst338.cst438_p1

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
@Entity(tableName = "users")
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "password") val password: String?

)
