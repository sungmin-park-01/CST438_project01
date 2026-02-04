package com.cst338.cst438_p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cst338.cst438_p1.ui.theme.CST438_P1Theme


class SignupActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CST438_P1Theme{
                SignupScreen(
                    onSignupComplete = {
                        finish()
                    }
                )
            }

        }
    }
}