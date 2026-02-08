package com.cst338.cst438_p1

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JokeScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<JokeActivity>()

    @Test
    fun jokeScreen_showsButtons() {
        composeTestRule.onNodeWithText("Back").assertIsDisplayed()
        composeTestRule.onNodeWithText("New Joke").assertIsDisplayed()
        composeTestRule.onNodeWithText("Favorite").assertIsDisplayed()
    }
}
