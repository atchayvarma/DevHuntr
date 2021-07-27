package tech.tamilanapps.devhuntr.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val ColorPalette = darkColors(
    primary = primaryGrey,
    primaryVariant = primaryGrey,
    secondary = secondaryWhite
)


@Composable
fun DevHuntrTheme(content: @Composable() () -> Unit) {


    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}