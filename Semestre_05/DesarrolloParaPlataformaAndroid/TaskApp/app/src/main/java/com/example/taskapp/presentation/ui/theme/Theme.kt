package com.example.taskapp.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Blue,
    onPrimary = DarkBackground,
    primaryContainer = DarkBlue,
    onPrimaryContainer = TextColorLight,
    secondary = AccentBlue,
    onSecondary = DarkBackground,
    background = DarkBackground,
    surface = SurfaceColor,
    onBackground = TextColorLight,
    onSurface = TextColorLight
)

private val LightColorScheme = lightColorScheme(
    primary = LightBlue,
    onPrimary = TextColor,
    primaryContainer = Blue,
    onPrimaryContainer = TextColor,
    secondary = DarkBlue,
    onSecondary = TextColor,
    background = BackgroundBlue,
    surface = Color.White,
    onBackground = TextColor,
    onSurface = TextColor,
)

@Composable
fun TaskAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = poppinsTypo,
        content = content
    )
}