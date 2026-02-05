package com.cst338.cst438_p1

import androidx.compose.ui.graphics.toArgb
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ColorTest {
    @Test
    fun colors_areExpectedHex() {
        assertEquals(0xFFF7F7F7.toInt(), Background.toArgb())
        assertEquals(0xFFF5C542.toInt(), Button.toArgb())
        assertEquals(0xFF4A90E2.toInt(), Bar.toArgb())
        assertEquals(0xFF1C1C1C.toInt(), ButtonText.toArgb())
        assertEquals(0xFF1C1C1C.toInt(), Text.toArgb())
        assertEquals(0xFFE6E6E6.toInt(), BrandName.toArgb())
    }
}