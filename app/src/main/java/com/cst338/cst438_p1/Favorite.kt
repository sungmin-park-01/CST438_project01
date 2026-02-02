package com.cst338.cst438_p1

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Favorite")
data class Favorite (
    @ColumnInfo val uid: Int,
    @ColumnInfo(name = "joke_id") val jokeId: String
)