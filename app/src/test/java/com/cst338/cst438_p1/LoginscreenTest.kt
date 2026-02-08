package com.cst338.cst438_p1

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import junit.framework.TestCase.assertTrue
import org.junit.Rule
import org.junit.Test
import retrofit2.http.GET

class LoginscreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loginButton_empty(){
        val login = false

        composeTestRule.setContent{
            LoginScreen(
                onLoginSuccess = { val login = true},
                onSignupClick = {}
            )
        }

        composeTestRule.onNodeWithText("Login").performClick()
        assertTrue("Login should not be called with empty fields",!login)
    }
    @Test
    fun loginButtonValid(){
        val login = false
        composeTestRule.setContent{
            LoginScreen(
                onLoginSuccess = {val login = true},
                onSignupClick = {}
            )
        }
        composeTestRule.onNodeWithText("Username").performTextInput("testuser")
        composeTestRule.onNodeWithText("password").performTextInput("1234")
        composeTestRule.onNodeWithText("Login").performClick()
        assertTrue("Login should be called with all fields full",login)
    }

    @Test
    fun signupPath(){
        var signup = false
        composeTestRule.setContent{
            LoginScreen(
                onLoginSuccess = {},
                onSignupClick = {signup = true}
            )
        }
        composeTestRule.onNodeWithText("Sign up!").performClick()
        assertTrue(signup)
    }
}