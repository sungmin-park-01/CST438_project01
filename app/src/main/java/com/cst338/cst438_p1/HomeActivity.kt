package com.cst338.cst438_p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var joke by remember { mutableStateOf("Loading…") }
            var jokeID by remember { mutableStateOf("") }

            // Load once when screen opens
            LaunchedEffect(Unit) {
                joke = withContext(Dispatchers.IO) {
                    try {
                        val response = RetrofitClient.dadJokeApi.getRandomJoke()
                        if (response.isSuccessful) {
                            response.body()?.joke ?: "No joke returned."
                        } else {
                            "HTTP ${response.code()}"
                        }
                    } catch (e: Exception) {
                        "Network error: ${e.message}"
                    }
                }
                jokeID = withContext(Dispatchers.IO) {
                    try {
                        val response = RetrofitClient.dadJokeApi.getRandomJoke()
                        if (response.isSuccessful) {
                            response.body()?.id ?: "No id returned."
                        } else {
                            "HTTP ${response.code()}"
                        }
                    } catch (e: Exception) {
                        "Network error: ${e.message}"
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = joke)
                Text(text = jokeID)

                Button(onClick = {
                    // get a new joke
                    lifecycleScope.launch {
                        joke = withContext(Dispatchers.IO) {
                            try {
                                val response = RetrofitClient.dadJokeApi.getRandomJoke()
                                if (response.isSuccessful) response.body()?.joke ?: "No joke returned."
                                else "HTTP ${response.code()}"
                            } catch (e: Exception) {
                                "Network error: ${e.message}"
                            }
                        }
                        jokeID = withContext(Dispatchers.IO) {
                            try {
                                val response = RetrofitClient.dadJokeApi.getRandomJoke()
                                if (response.isSuccessful) response.body()?.id ?: "No joke returned."
                                else "HTTP ${response.code()}"
                            } catch (e: Exception) {
                                "Network error: ${e.message}"
                            }
                        }
                    }
                }) {
                    Text("New Joke")
                }
            }
        }
    }
}
