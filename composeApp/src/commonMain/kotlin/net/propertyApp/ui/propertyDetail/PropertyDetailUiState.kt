package net.propertyApp.ui.propertyDetail

import net.propertyApp.domain.properties.entities.Property
import net.propertyApp.ui.common.Action
import net.propertyApp.ui.common.Event
import net.propertyApp.ui.common.UiState

sealed class PropertyDetailUiState: UiState {

    object Loading : PropertyDetailUiState()

    data class DisplayingPropertyDetail(val property: Property) : PropertyDetailUiState()

    data class Error(val message: String) : PropertyDetailUiState()

}

sealed class PropertyDetailEvent: Event {

    data class OnScreenLoad(val propertyId: String) : PropertyDetailEvent()

    data object OnUpButtonClicked : PropertyDetailEvent()
}

sealed class PropertyDetailAction: Action {

    data object NavigateToProperties : PropertyDetailAction()

}