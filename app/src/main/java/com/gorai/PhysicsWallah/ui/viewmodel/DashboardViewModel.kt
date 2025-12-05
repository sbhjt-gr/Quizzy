package com.gorai.PhysicsWallah.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorai.PhysicsWallah.data.repository.DashboardRepository
import com.gorai.PhysicsWallah.ui.state.DashboardUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val repository: DashboardRepository = DashboardRepository()
) : ViewModel() {

    private val _state = MutableStateFlow<DashboardUiState>(DashboardUiState.Loading)
    val state: StateFlow<DashboardUiState> = _state.asStateFlow()

    init {
        loadDashboard()
    }

    fun loadDashboard() {
        viewModelScope.launch {
            _state.value = DashboardUiState.Loading
            repository.getDashboard()
                .onSuccess { data ->
                    _state.value = DashboardUiState.Success(data)
                }
                .onFailure { error ->
                    _state.value = DashboardUiState.Error(error.message)
                }
        }
    }
}
