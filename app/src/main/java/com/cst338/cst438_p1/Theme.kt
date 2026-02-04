package com.cst338.cst438_p1

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val AppColors = lightColorScheme(
    primary = Button,
    onPrimary = ButtonText,
    background = Background,
    primaryContainer = Bar,
    onPrimaryContainer = Text,
    onSurface = Text
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColors,
        content = content
    )
}