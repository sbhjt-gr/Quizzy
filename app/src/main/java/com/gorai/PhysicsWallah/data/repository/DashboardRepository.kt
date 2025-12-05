package com.gorai.PhysicsWallah.data.repository

import android.util.Log
import com.gorai.PhysicsWallah.data.model.StudentDashboard
import com.gorai.PhysicsWallah.data.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class DashboardRepository {
    private val api = RetrofitClient.apiService

    suspend fun getDashboard(): Result<StudentDashboard> = withContext(Dispatchers.IO) {
        try {
            val response = api.getDashboard()
            Result.success(response)
        } catch (e: UnknownHostException) {
            Log.e("DashboardRepo", "UnknownHost: ${e.message}")
            Result.failure(Exception("No internet connection"))
        } catch (e: Exception) {
            Log.e("DashboardRepo", "Error: ${e.javaClass.simpleName} - ${e.message}")
            Result.failure(e)
        }
    }
}
