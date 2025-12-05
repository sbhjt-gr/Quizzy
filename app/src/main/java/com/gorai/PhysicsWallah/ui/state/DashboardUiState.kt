package com.gorai.PhysicsWallah.ui.state

import com.gorai.PhysicsWallah.data.model.StudentDashboard

sealed class DashboardUiState {
    data object Loading : DashboardUiState()
    data class Success(val data: StudentDashboard) : DashboardUiState()
    data class Error(val message: String?) : DashboardUiState()
}
