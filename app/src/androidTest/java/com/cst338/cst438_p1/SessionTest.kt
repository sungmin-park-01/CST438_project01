package com.cst338.cst438_p1

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SessionTest {
    @Test
    fun login_and_logout_work() = runTest {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val sessionManager = SessionManager(context)

        sessionManager.logout()

        sessionManager.login(123)

        val loggedInId = sessionManager.userId.first()
        assertEquals(123, loggedInId)

        sessionManager.logout()

        val loggedOutId = sessionManager.userId.first()
        assertNull(loggedOutId)
    }

}