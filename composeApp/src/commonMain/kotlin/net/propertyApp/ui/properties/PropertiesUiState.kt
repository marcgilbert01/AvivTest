package net.propertyApp.ui.properties

import net.propertyApp.domain.properties.entities.Property
import net.propertyApp.ui.common.Action
import net.propertyApp.ui.common.Event
import net.propertyApp.ui.common.UiState

sealed class PropertiesUiState : UiState {
    object Loading : PropertiesUiState()
    data class DisplayingProperties(
        val properties: List<Property>
    ) : PropertiesUiState()
}

sealed class PropertiesEvent: Event {

    data class OnPropertyClicked(val propertyId: String) : PropertiesEvent()
}

sealed class PropertiesAction : Action {

    data class NavigateToPropertyDetails(val propertyId: String) : PropertiesAction()
}