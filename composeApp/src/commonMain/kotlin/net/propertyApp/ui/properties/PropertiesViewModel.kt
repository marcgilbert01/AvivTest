package net.propertyApp.ui.properties

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.propertyApp.domain.properties.usecase.GetAllPropertiesUseCase
import net.propertyApp.ui.common.BaseViewModel

class PropertiesViewModel(
    private val getAllPropertiesUseCase: GetAllPropertiesUseCase
) : BaseViewModel<PropertiesEvent, PropertiesUiState, PropertiesAction>() {

    init {
        setInitialState(PropertiesUiState.Loading)
        viewModelScope.launch {
            getAllPropertiesUseCase().let {
                setUiState {
                    PropertiesUiState.DisplayingProperties(it)
                }
            }
        }
    }

    override fun handleEvent(event: PropertiesEvent) {
        viewModelScope.launch {
            when (event) {
                is PropertiesEvent.OnPropertyClicked -> {
                    sendAction { PropertiesAction.NavigateToPropertyDetails(event.propertyId) }
                }
            }
        }
    }
}