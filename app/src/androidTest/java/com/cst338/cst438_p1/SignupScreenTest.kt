package com.cst338.cst438_p1

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class SignupScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var db: AppDatabase
    private  lateinit var userDao: UserDao

    @Before
    fun setup(){
        val context = ApplicationProvider.getApplicationContext<Context>()

        db= AppDatabase.getDatabase(context,kotlinx.coroutines.GlobalScope)
        userDao = db.userDao()

        runBlocking {
            userDao.insert(User(username = "existing_user", password = "password"))
        }
    }
    @After
    fun teardown(){

    }
    @Test
    fun signupPass(){
        var signupCheck = false

        composeTestRule.setContent {
            AppTheme {
                SignupScreen(onSignupComplete = { signupCheck = true })
            }
        }
        composeTestRule.onNodeWithText("Enter new username").performTextInput("new_user")
        composeTestRule.onNodeWithText("Enter new password").performTextInput("secure_pass")

        composeTestRule.onNodeWithText("Sign up").performClick()
        composeTestRule.waitForIdle()
        assert(signupCheck)
    }

    @Test
    fun signupDupUser(){
        var signupCheck = false

        composeTestRule.setContent {
            AppTheme {
                SignupScreen(onSignupComplete = { signupCheck = true })
            }
        }

        composeTestRule.onNodeWithText("Enter new username").performTextInput("existing_user")
        composeTestRule.onNodeWithText("Enter new password").performTextInput("password123")
        composeTestRule.onNodeWithText("Sign up").performClick()

        composeTestRule.waitForIdle()
        assert(!signupCheck)
    }
    @Test
    fun signupEmpty(){
        var signupCheck = false

        composeTestRule.setContent {
            AppTheme {
                SignupScreen(onSignupComplete = { signupCheck = true })
            }
        }
        composeTestRule.onNodeWithText("Sign up").performClick()
        composeTestRule.waitForIdle()
        assert(!signupCheck)
    }
    @Test
    fun signupUi(){
        composeTestRule.setContent {
            AppTheme {
                SignupScreen(onSignupComplete = {})
            }
        }
        composeTestRule.onNodeWithText("Create account").assertExists()
        composeTestRule.onNodeWithText("Enter new username").assertExists()
        composeTestRule.onNodeWithText("Enter new password").assertExists()
        composeTestRule.onNodeWithText("Sign up").assertExists()
    }
}