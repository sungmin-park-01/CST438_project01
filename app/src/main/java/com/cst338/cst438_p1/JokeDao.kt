package com.cst338.cst438_p1

import androidx.room.Dao
import androidx.room.Query

@Dao
interface JokeDao {
    @Query("SELECT * FROM Joke")
    fun getAllJokes(): List<Joke>
}