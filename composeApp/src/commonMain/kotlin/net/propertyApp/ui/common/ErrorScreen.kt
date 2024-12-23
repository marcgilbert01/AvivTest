package net.propertyApp.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.propertyApp.designSystem.tokens.avivTypography


@Composable
fun ErrorScreen(errorMessage: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(errorMessage, style = avivTypography.body1)
    }
}