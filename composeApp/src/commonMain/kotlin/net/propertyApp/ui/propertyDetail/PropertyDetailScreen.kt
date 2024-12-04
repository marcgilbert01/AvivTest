package net.propertyApp.ui.propertyDetail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import net.propertyApp.designSystem.atoms.UpButton
import net.propertyApp.designSystem.tokens.avivColors
import net.propertyApp.designSystem.tokens.avivTypography
import net.propertyApp.domain.properties.entities.Property
import net.propertyApp.ui.common.ErrorScreen
import net.propertyApp.ui.common.LoadingScreen
import net.propertyApp.ui.common.formatAmount
import net.propertyApp.ui.common.viewModel

@Composable
fun PropertyDetailScreen(
    viewModel: PropertyDetailViewModel = viewModel(PropertyDetailViewModel::class),
    propertyId: String,
    navHostController: NavHostController
) {

    val propertyDetailUiState: State<PropertyDetailUiState> = viewModel.uiState.collectAsState(PropertyDetailUiState.Loading)
    val event: (PropertyDetailEvent) -> Unit = { viewModel.handleEvent(it) }
    LaunchedEffect(key1 = propertyId) {
        event(PropertyDetailEvent.OnScreenLoad(propertyId))
    }

    Column {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            when (val uiState = propertyDetailUiState.value) {
                is PropertyDetailUiState.Loading -> {
                    LoadingScreen()
                }
                is PropertyDetailUiState.Error -> {
                    ErrorScreen(uiState.message)
                }
                is PropertyDetailUiState.DisplayingPropertyDetail -> {
                    PropertyDetailView(uiState.property, event)
                }
            }
        }
    }
    LaunchedEffect(viewModel.action) {
        viewModel.action.collect{
            when(it){
                is PropertyDetailAction.NavigateToProperties -> {
                    navHostController.navigateUp()
                }
            }
        }
    }
}

@Composable
fun PropertyDetailView(
    property: Property,
    event: (PropertyDetailEvent) -> Unit
) {
    Column {
        UpButton("Back to properties") {
            event(PropertyDetailEvent.OnUpButtonClicked)
        }
        Text(
            text = property.type,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = avivTypography.h1
        )
        Row {
            LeftTableCell("Property Ref")
            RightTableCell(property.id.toString())
        }
        Row{
            LeftTableCell("City")
            RightTableCell(property.city)
        }
        Row {
            LeftTableCell("Price")
            RightTableCell(property.price.formatAmount())
        }
        Row {
            LeftTableCell("Area")
            RightTableCell(property.area.formatAmount())
        }
        Row {
            LeftTableCell("Agency")
            RightTableCell(property.professional)
        }
        property.rooms?.let {
            Row {
                LeftTableCell("Rooms")
                RightTableCell(it.toString())
            }
        }
        property.bedrooms?.let {
            Row {
                LeftTableCell("Bedrooms")
                RightTableCell(it.toString())
            }
        }
    }
}


@Composable
fun RowScope.LeftTableCell(text: String) {
    Text(text = text, Modifier.border(1.dp, avivColors.primary).weight(0.3f).padding(8.dp))
}


@Composable
fun RowScope.RightTableCell(text: String) {
    Text(text = text, Modifier.border(1.dp, avivColors.primary).weight(0.3f).padding(8.dp))
}

