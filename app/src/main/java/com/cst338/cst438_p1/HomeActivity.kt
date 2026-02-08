package com.cst338.cst438_p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = AppDatabase.getDatabase(this, lifecycleScope)
        val userDao = db.userDao()

        val userIdKey = "CST438P1.UserId.Key"
        val loggedInUserId = intent.getIntExtra(userIdKey, -1)

        var user: User
        lifecycleScope.launch {
            user = userDao.getUserById(loggedInUserId)!!

            setContent {
                AppTheme {
                    HomeScreen(user)
                }
            }
        }
    }
}

