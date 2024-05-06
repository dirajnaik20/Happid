package com.example.toolyttask.presentation.model

data class LoginUIState(
    val requestOTPButtonState: Boolean,
    val submitOTPButtonState: Boolean,
    val submitFormButtonState: Boolean,
    val otp: Number,
    val loginInfo: LoginInfo
)

data class LoginInfo(
    val firstName: String,
    val lastName: String,
    val phoneNumber: Number,
    val postCode: Number
)