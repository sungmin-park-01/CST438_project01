package com.cst338.cst438_p1

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete

@Dao
interface UserDao {
    @Query("SELECT * FROM USERS")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM users WHERE username LIKE :first AND " +
            "password LIKE :last LIMIT 1")
    fun findByUserName(first: String, last: String): User
    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Delete
    fun deleteJoke(joke: Joke)

}