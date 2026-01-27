package com.cst338.cst438_p1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginScreen(
                onLoginSuccess = {
                    startActivity(Intent(this, HomeActivity::class.java))
                },
                onSignupClick = {
                    startActivity(Intent(this, SignupActivity::class.java))
                }
            )
        }
    }
}