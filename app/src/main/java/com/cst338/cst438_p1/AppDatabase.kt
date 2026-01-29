package com.cst338.cst438_p1

import android.content.Context
import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{

        }
    }
}