package com.cst338.cst438_p1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cst338.cst438_p1.ui.theme.CST438_P1Theme

class FavoritesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FavoriteScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(name: String, modifier: Modifier = Modifier) {
    //TODO: update this or the onCreate to load in the logged-in user

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favorites") },
                navigationIcon = { IconButton(onClick = {
                    val intent = Intent(context, HomeActivity::class.java)
                    context.startActivity(intent)
                })  {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null
                    )
                }},
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.fillMaxWidth().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            userScrollEnabled = true) {
            //TODO: Actually get the data from DB first and adjust the for loop here accordingly.
            //TODO: a long click/tap on the items here should bring up an option to delete them.

            for(i in 1..20) {
                item {
                        Card(modifier = Modifier.fillMaxWidth().padding(8.dp),
                            border = BorderStroke(1.dp, color = Color.Black)
                        ) {
                            //Not sure why, but the Box within a Box is the only way I could get this
                            //to center the content AND also not have the text clip the rounded edges
                            //of the Cards.
                            Box(modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center) {
                                    Box(modifier = Modifier.fillMaxWidth(0.95f),
                                        contentAlignment = Alignment.Center)
                                {
                                    Text("Why do you never see elephants hiding in trees? Because they're so good at it.",
                                        textAlign = TextAlign.Center,
                                        color = Color.Black)
                                }
                            }
                        }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteScreenPreview() {
    AppTheme {
        FavoriteScreen("Android")
    }
}