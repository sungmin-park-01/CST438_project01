package com.cst338.cst438_p1

import androidx.room.Dao
import androidx.room.Query

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM Favorite")
    fun getAllFavorites(): List<Favorite>
}