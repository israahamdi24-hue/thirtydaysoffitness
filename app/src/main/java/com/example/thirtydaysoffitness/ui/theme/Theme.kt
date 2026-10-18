package com.example.thirtydaysoffitness.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val LightColors = lightColorScheme(
    primary = Color(0xFFB84A00), onPrimary = Color.White,
    primaryContainer = Color(0xFFFFDBCA), onPrimaryContainer = Color(0xFF380D00),
    secondary = Color(0xFF4F5B66), secondaryContainer = Color(0xFFD3DEEB),
    tertiary = Color(0xFF006A6A), tertiaryContainer = Color(0xFF9CF1F0),
    background = Color(0xFFFFF8F5), surface = Color(0xFFFFF8F5),
    surfaceVariant = Color(0xFFF5DED3), onSurface = Color(0xFF211A16),
    onBackground = Color(0xFF211A16)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFFB693), onPrimary = Color(0xFF591D00),
    primaryContainer = Color(0xFF822E00), onPrimaryContainer = Color(0xFFFFDBCA),
    secondary = Color(0xFFB7C9D9), secondaryContainer = Color(0xFF384956),
    tertiary = Color(0xFF80D5D4), tertiaryContainer = Color(0xFF004F4F),
    background = Color(0xFF19120E), surface = Color(0xFF19120E),
    surfaceVariant = Color(0xFF52443C), onSurface = Color(0xFFF0DFD7),
    onBackground = Color(0xFFF0DFD7)
)

private val AppTypography = Typography(
    displayLarge = TextStyle(fontWeight = FontWeight.Bold, fontSize = 26.sp, lineHeight = 34.sp),
    headlineSmall = TextStyle(fontWeight = FontWeight.Medium, fontSize = 20.sp, lineHeight = 28.sp),
    labelSmall = TextStyle(fontWeight = FontWeight.Bold, fontSize = 13.sp, letterSpacing = 1.sp),
    bodyLarge = TextStyle(fontWeight = FontWeight.Normal, fontSize = 15.sp, lineHeight = 24.sp)
)

private val AppShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(topStart = 28.dp, topEnd = 6.dp, bottomEnd = 28.dp, bottomStart = 6.dp),
    large = RoundedCornerShape(16.dp)
)

@Composable
fun ThirtyDaysOfFitnessTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}