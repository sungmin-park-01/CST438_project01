package com.cst338.cst438_p1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cst338.cst438_p1.ui.theme.CST438_P1Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Dad Joke")
                }
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ){
                    Button(
                        onClick = { println("haha") },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Logout")
                    }

                    Button(
                        onClick = { println("haha") },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Close")
                    }
                }
            }
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Hello (User name)"
            )

            Button(
                onClick = {print("haha")},
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("New Jokes")
            }

            Button(
                onClick = {print("haha")},
                modifier = Modifier.padding(top = 2.dp)
            ) {
                Text("My Favorite Jokes")
            }

            Button(
                onClick = {print("haha")},
                modifier = Modifier.padding(top = 2.dp)
            ) {
                Text("Profile")
            }



        }
    }
}

@Preview(device = Devices.PIXEL_7, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    CST438_P1Theme {
        HomeScreen()
    }
}
