package net.propertyApp.ui

import androidx.compose.runtime.Composable
import net.propertyApp.ui.common.withViewModelStoreOwner
import net.propertyApp.ui.mainScreen.MainScreen

@Composable
fun App() = withViewModelStoreOwner {
    MainScreen()
}