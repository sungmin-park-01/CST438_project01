package com.cst338.cst438_p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope

class JokeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userIdKey = "CST438P1.UserId.Key"
        val userId = intent.getIntExtra(userIdKey, -1)
        val db = AppDatabase.getDatabase(this, lifecycleScope)
        val jokeDao = db.jokeDao()
        val favoriteDao = db.favoriteDao()

        setContent {
            AppTheme {
                JokeScreen(
                    userId = userId,
                    jokeDao = jokeDao,
                    favoriteDao = favoriteDao,
                    onBack = { finish() }
                )
            }
        }
    }
}
