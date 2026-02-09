package com.cst338.cst438_p1

import android.content.Context
import android.content.Intent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.runner.AndroidJUnit4
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.allOf
import org.junit.runner.RunWith
import java.util.concurrent.CompletableFuture.allOf


class LoginscreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val userIdKey = "CST438P1.UserId.Key"

    @Before
    fun setup(){
        Intents.init()

        val context = ApplicationProvider.getApplicationContext<Context>()

        val db = AppDatabase.getDatabase(context, kotlinx.coroutines.GlobalScope)
        val userDao = db.userDao()

        runBlocking {
            userDao.insert(User(uid = 100, username = "testuser", password = "password123"))
        }
    }
    @After
    fun teardown(){
        Intents.release()
    }

    @Test
    fun loginSuccess(){
        composeTestRule.onNodeWithText("Username").performTextInput("testuser")
        composeTestRule.onNodeWithText("password").performTextInput("password123")
        composeTestRule.onNodeWithText("Login").performClick()
        composeTestRule.waitForIdle()
        Intents.intended(allOf(hasComponent(HomeActivity::class.java.name), hasExtra(userIdKey, 100)))
    }
    @Test
    fun signupButton(){
        composeTestRule.onNodeWithText("Sign up!").performClick()
        Intents.intended(hasComponent(SignupActivity::class.java.name))
    }

    @Test
    fun loginEmpty(){
        composeTestRule.onNodeWithText("Login").performClick()
        assert(Intents.getIntents().isEmpty())
    }
//    @Test
//    fun loginNoUser(){
//        composeTestRule.onNodeWithText("Username").performTextInput("Unknown")
//        composeTestRule.onNodeWithText("password").performTextInput("1234")
//
//        composeTestRule.onNodeWithText("Login").performClick()
//        assert(Intents.getIntents().isEmpty())
//    }
//    @Test
//    fun logingWrongPassword(){
//        composeTestRule.onNodeWithText("Username").performTextInput("testuser")
//        composeTestRule.onNodeWithText("Password").performTextInput("wrongpass")
//
//        composeTestRule.onNodeWithText("Login").performClick()
//        composeTestRule.waitForIdle()
//    }
//

//    @Test
//    fun devSkip(){
//        composeTestRule.onNodeWithText("Dev: Skip Login").performClick()
//        Intents.intended(hasComponent(HomeActivity::class.java.name))
//    }
}


