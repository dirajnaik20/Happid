package com.example.toolyttask.data.repository

import com.example.toolyttask.data.remote.ApiService
import com.example.toolyttask.data.remote.dto.Login
import com.example.toolyttask.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : LoginRepository {
    override suspend fun sendLogin(login: Login) {
        apiService.sendDataToApi(login)
    }
}