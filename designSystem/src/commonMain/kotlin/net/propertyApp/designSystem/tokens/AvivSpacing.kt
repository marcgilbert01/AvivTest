package net.propertyApp.designSystem.tokens

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AvivSpacing(
    val smallSpacing: Dp,
    val screenHorizontalMargin: Dp,
    val listVerticalSpacing: Dp,
    val listItemHeight: Dp
)

val avivSpacing = AvivSpacing(
    smallSpacing = 4.dp,
    screenHorizontalMargin = 24.dp,
    listVerticalSpacing = 16.dp,
    listItemHeight = 80.dp
)