package com.google.opensource.composecodelab.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ComposeCodelabTheme(content: @Composable () -> Unit) {
    val colorScheme = lightColorScheme(
        primary = Melon,
        primaryContainer = PaleDogwood,
        onPrimary = Color.Black,
        secondary = Peach,
        onSecondary = Color.Black
    )

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}