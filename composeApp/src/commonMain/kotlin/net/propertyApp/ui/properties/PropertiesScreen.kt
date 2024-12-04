package net.propertyApp.ui.properties

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import net.propertyApp.designSystem.tokens.avivColors
import net.propertyApp.designSystem.tokens.avivSpacing
import net.propertyApp.designSystem.tokens.avivTypography
import net.propertyApp.designSystem.tokens.rememberChevronRight
import net.propertyApp.domain.properties.entities.Property
import net.propertyApp.ui.common.LoadingScreen
import net.propertyApp.ui.common.formatAmount
import net.propertyApp.ui.common.viewModel
import net.propertyApp.ui.mainScreen.Screens

@Composable
fun PropertiesScreen(
    viewModel: PropertiesViewModel = viewModel(PropertiesViewModel::class),
    navHostController: NavHostController
) {
    val propertiesUiState: State<PropertiesUiState> = viewModel.uiState.collectAsState(PropertiesUiState.Loading)
    val event: (PropertiesEvent) -> Unit = { viewModel.handleEvent(it) }

    when (val uiState = propertiesUiState.value) {
        is PropertiesUiState.DisplayingProperties -> {
            propertyListView(uiState, event)
        }
        PropertiesUiState.Loading -> {
            LoadingScreen()
        }
    }
    LaunchedEffect(viewModel.action) {
        viewModel.action.collect{
            when(it){
                is PropertiesAction.NavigateToPropertyDetails -> {
                    navHostController.navigate(route = "${Screens.PropertyDetails.name}/${it.propertyId}")
                }
            }
        }
    }
}

@Composable
private fun propertyListView(
    uiState: PropertiesUiState.DisplayingProperties,
    event: (PropertiesEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(avivColors.surface)
            .verticalScroll(rememberScrollState(0))
    ) {
        Text(
            text = "Properties",
            style = avivTypography.h1,
            modifier = Modifier.padding(avivSpacing.screenHorizontalMargin)
        )
        uiState.properties.forEach {
            PropertyMenuItem(
                property = it,
                onClicked = { propertyId ->
                    event(PropertiesEvent.OnPropertyClicked(propertyId))
                }
            )
        }
    }
}

@Composable
private fun PropertyMenuItem(
    property: Property,
    onClicked: (propertyId: String) -> Unit
) {
    Column(Modifier
        .fillMaxWidth()
        .background(avivColors.background)
        .padding(start = avivSpacing.screenHorizontalMargin)
    ) {
        Row(modifier = Modifier.fillMaxWidth().height(avivSpacing.listItemHeight),
            horizontalArrangement = SpaceBetween,
            verticalAlignment = CenterVertically,
        ) {
            Row(verticalAlignment = CenterVertically) {
                Text(property.type, style = avivTypography.body1)
                Text(property.city, style = avivTypography.body1)
            }
            Row(verticalAlignment = CenterVertically) {
                Text(property.price.formatAmount(), style = avivTypography.body2)
                Icon(
                    rememberChevronRight(),
                    "property details",
                    tint = avivColors.secondary,
                    modifier = Modifier
                        .clickable { onClicked(property.id.toString())}
                        .padding(start = avivSpacing.smallSpacing, end = avivSpacing.smallSpacing)
                )
            }
        }
        Divider(color = avivColors.surface, thickness = 1.dp)
    }
}