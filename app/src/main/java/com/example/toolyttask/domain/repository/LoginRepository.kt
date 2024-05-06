package com.example.toolyttask.domain.repository

import com.example.toolyttask.data.remote.dto.Login

interface LoginRepository {
    suspend fun sendLogin(login: Login)
}