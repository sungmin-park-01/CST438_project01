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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun LoginScreen(
        onLoginSuccess: () -> Unit,
        onSignupClick: () -> Unit
    ){
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        val context = androidx.compose.ui.platform.LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
                title = {
                    Text("Dad Joke")
                }
            )
        },
        bottomBar = {

        }
    ) {innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(24.dp).padding(innerPadding),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(bottom = 24.dp)
            )
            OutlinedTextField(
                value = username,
                onValueChange = { username = it},
                label = {Text("Username")},
                modifier = Modifier
                    .height(60.dp)
            )
            Spacer(modifier = Modifier.height((12.dp)))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it},
                label = {Text("password")},
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .height(60.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick={
                    if (username.isEmpty() || password.isEmpty()) {
                        Toast.makeText(context,"Please fill all fields", Toast.LENGTH_SHORT).show()
                    } else {
                        onLoginSuccess()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ){
                Text("Login")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Don't have an account?"
            )
            Button(
                onClick = onSignupClick,
                modifier = Modifier.fillMaxWidth()
            ){
                Text("Sign up!")
            }
            Button(onClick = onLoginSuccess) {
                Text("Dev: Skip Login")
            }
        }
    }
}

@Preview(device = Devices.PIXEL_7, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    AppTheme {
        LoginScreen (
            onLoginSuccess = {},
            onSignupClick = {}
        )
    }

}