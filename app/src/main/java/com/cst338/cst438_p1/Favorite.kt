package com.cst338.cst438_p1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorite", primaryKeys = ["uid", "joke_id"])
data class Favorite (
    @ColumnInfo val uid: Int,
    @ColumnInfo(name = "joke_id") val jokeId: String
)