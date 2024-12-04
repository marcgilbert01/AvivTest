package net.propertyApp.ui.mainScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import net.propertyApp.ui.propertyDetail.PropertyDetailScreen
import net.propertyApp.ui.properties.PropertiesScreen

enum class Screens {
    PropertyList,
    PropertyDetails
}

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screens.PropertyList.name,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = Screens.PropertyList.name) {
            PropertiesScreen(navHostController = navController)
        }
        composable(
            route = "${Screens.PropertyDetails.name}/{propertyId}",
            arguments = listOf(navArgument("propertyId") {
                type = NavType.StringType
                nullable = true
            })
        ) {navBackStackEntry ->
            PropertyDetailScreen(
                propertyId = navBackStackEntry.arguments?.getString("propertyId")!!,
                navHostController = navController
            )
        }
    }
}