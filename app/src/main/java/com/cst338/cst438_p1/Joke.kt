package com.cst338.cst438_p1

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Joke")
data class Joke (
    @ColumnInfo(name = "joke_id") val jokeId: String,
    @ColumnInfo(name = "joke") val joke: String
)