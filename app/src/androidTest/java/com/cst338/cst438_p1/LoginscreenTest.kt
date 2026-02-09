package com.cst338.cst438_p1

import android.content.Context
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import org.hamcrest.CoreMatchers.allOf



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
            userDao.insert(User(uid = 1, username = "testuser", password = "password123"))
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
        Intents.intended(allOf(hasComponent(HomeActivity::class.java.name), hasExtra(userIdKey, 1)))
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
    @Test
    fun devSkip(){
        composeTestRule.onNodeWithText("Dev: Skip Login").performClick()
        Intents.intended(hasComponent(HomeActivity::class.java.name))
    }

    @Test
    fun logingWrongPassword(){
        composeTestRule.onNodeWithText("Username").performTextInput("testuser")
        composeTestRule.onNodeWithText("password").performTextInput("wrong_pass")
        composeTestRule.onNodeWithText("Login").performClick()

        composeTestRule.waitForIdle()
        assert(Intents.getIntents().isEmpty())
    }



}


