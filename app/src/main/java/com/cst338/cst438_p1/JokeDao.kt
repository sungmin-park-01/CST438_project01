package com.cst338.cst438_p1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface JokeDao {
    @Query("SELECT * FROM Joke")
    fun getAllJokes(): List<Joke>

    @Query("SELECT joke_id, joke " +
            "FROM Joke " +
            "NATURAL JOIN Favorite " +
            "WHERE uid = :uid")
    suspend fun getJokeByUserId(uid: Int): List<Joke>

    @Insert
    suspend fun insert(joke: Joke)
}