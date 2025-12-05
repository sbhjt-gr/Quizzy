package com.gorai.PhysicsWallah.data.repository

import com.gorai.PhysicsWallah.data.model.StudentDashboard
import com.gorai.PhysicsWallah.data.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DashboardRepository {
    private val api = RetrofitClient.apiService

    suspend fun getDashboard(): Result<StudentDashboard> = withContext(Dispatchers.IO) {
        try {
            val response = api.getDashboard()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
