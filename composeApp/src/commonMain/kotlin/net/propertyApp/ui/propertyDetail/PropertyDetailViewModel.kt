package net.propertyApp.ui.propertyDetail

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.propertyApp.domain.properties.usecase.GetPropertyUseCase
import net.propertyApp.ui.common.BaseViewModel

class PropertyDetailViewModel(
    private val getPropertyUseCase: GetPropertyUseCase
) : BaseViewModel<PropertyDetailEvent, PropertyDetailUiState, PropertyDetailAction>() {

    init {
        setInitialState(PropertyDetailUiState.Loading)
    }

    override fun handleEvent(event: PropertyDetailEvent) {
        viewModelScope.launch {
            try {
                when (event) {
                    PropertyDetailEvent.OnUpButtonClicked -> {
                        sendAction { PropertyDetailAction.NavigateToProperties }
                    }
                    is PropertyDetailEvent.OnScreenLoad -> {
                        getAndDisplayPropertyDetail(event.propertyId)
                    }
                }
            } catch (e: Exception) {
                setUiState { PropertyDetailUiState.Error(e.message!!) }
            }
        }
    }

    private suspend fun getAndDisplayPropertyDetail(propertyId: String) {
        getPropertyUseCase(propertyId)?.let { property ->
            setUiState {
                PropertyDetailUiState.DisplayingPropertyDetail(property)
            }
        }
    }
}