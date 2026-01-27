package com.cst338.cst438_p1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun SignupScreen(
    onSignupComplete: () -> Unit
){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = androidx.compose.ui.Modifier.fillMaxSize().padding(24.dp)
    ) {
        Text(
            text = "Create account",
            modifier = androidx.compose.ui.Modifier.padding(bottom = 24.dp)
        )

    }
}