package com.cst338.cst438_p1

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cst338.cst438_p1.ui.theme.CST438_P1Theme

class FavoritesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CST438_P1Theme {
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

    val activity = LocalActivity.current

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text("Favorites") },
                navigationIcon = { IconButton(onClick = { activity?.finish() })  {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null
                    )
                }},
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.fillMaxWidth().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally) {
            //TODO: Actually get the data from DB first and adjust the for loop here accordingly.
            //TODO: a long click/tap on the items here should bring up an option to delete them.

            for(i in 1..50) {
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
                                    Text("Item " + i,
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
    CST438_P1Theme {
        FavoriteScreen("Android")
    }
}