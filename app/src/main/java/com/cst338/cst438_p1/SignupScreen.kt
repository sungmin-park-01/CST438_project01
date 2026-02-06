package com.cst338.cst438_p1

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(
    onSignupComplete: () -> Unit,
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    val scope = rememberCoroutineScope()
    val db = AppDatabase.getDatabase(context, scope)
    val userDao = db.userDao()


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dad Joke") },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(24.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Create account",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 24.dp)
            )
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Enter new username") },
                modifier = androidx.compose.ui.Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter new password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = androidx.compose.ui.Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    if (username.isEmpty() || password.isEmpty()) {
                        Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        scope.launch {
                            val existing = userDao.getUser(username)

                            if (existing != null) {
                                Toast.makeText(
                                    context,
                                    "Username already exists",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                userDao.insert(User(username = username, password = password))
                                onSignupComplete()
                            }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign up!")
            }
        }
    }
}


//@Preview(device = Devices.PIXEL_7, showSystemUi = true)
//@Composable
//fun SignupScreenPreview() {
//    AppTheme {
//        SignupScreen (
//            onSignupComplete = { }
//        )
//    }
//
//}