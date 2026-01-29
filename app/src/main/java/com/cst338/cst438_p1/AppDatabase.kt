package com.cst338.cst438_p1

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database-name"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

