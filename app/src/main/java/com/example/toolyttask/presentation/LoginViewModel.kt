package com.example.toolyttask.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toolyttask.data.remote.dto.Login
import com.example.toolyttask.domain.repository.LoginRepository
import com.example.toolyttask.presentation.model.LoginInfo
import com.example.toolyttask.presentation.model.LoginUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {


    private var _firstName = mutableStateOf("")
    val firstName = _firstName

    private var _lastName = mutableStateOf("")
    val lastName = _lastName

    private var _phoneNumber = mutableStateOf("")
    val phoneNumber = _phoneNumber

    private var _postCode = mutableStateOf("")
    val postCode = _postCode

    private var _OTP = mutableStateOf("")
    val OTP = _OTP

    private var isSubmitFormButtonClicked = mutableStateOf(false)

    private val PHONE_NUMBER_REGEX = Regex("^\\+?(91)?[6789]\\d{9}\$")
    fun updateFirstName(updatedFirstName: String) {
        _firstName.value = updatedFirstName
    }

    fun updateLastName(updatedLastName: String) {
        _lastName.value = updatedLastName
    }

    fun updatePhoneNumber(updatedPhoneNumber: String) {
        _phoneNumber.value = updatedPhoneNumber
    }

    fun updatePostCode(updatedPostCode: String) {
        _postCode.value = updatedPostCode
    }

    fun sendLoginDetails():Boolean {
        // Define regular expressions for Indian phone number and post code
//        val PHONE_NUMBER_REGEX = Regex("^\\+?(91)?[6789]\\d{9}\$")
        val POST_CODE_REGEX = Regex("^[1-9][0-9]{5}\$")

        // Validate phone number
        val isPhoneNumberValid = PHONE_NUMBER_REGEX.matches(_phoneNumber.value)

        // Validate post code
        val isPostCodeValid = POST_CODE_REGEX.matches(_postCode.value)

        // Check if all fields are valid
        val isValid = isSubmitFormButtonClicked.value ||
                _firstName.value.isNotEmpty() ||
                _lastName.value.isNotEmpty() ||
                isPhoneNumberValid ||
                isPostCodeValid

        // If all fields are valid, send the login request
        if (isValid) {
            viewModelScope.launch(Dispatchers.IO) {
                loginRepository.sendLogin(
                    Login(
                    firstName=firstName.value,
                    lastName=lastName.value,
                    phoneNumber=phoneNumber.value,
                    postCode=postCode.value
                )
                )
            }
            isSubmitFormButtonClicked.value=false

            return true

        }
        return false
    }

    fun generateOTP(phoneNumber: String): String {
        // Clean the phone number by removing non-numeric characters
        val cleanedPhoneNumber = phoneNumber.filter { it.isDigit() }

        // Check if the cleaned phone number is a valid Indian phone number
        if (!PHONE_NUMBER_REGEX.matches(cleanedPhoneNumber)) {
            return "" // Return empty string if the phone number is invalid
        }

        // Check if the cleaned phone number has at least 4 digits
        if (cleanedPhoneNumber.length < 4) {
            return "" // Return empty string if the phone number is too short
        }

        // Extract the first two digits and the last two digits of the cleaned phone number
        val firstTwoDigits = cleanedPhoneNumber.substring(0, 2)
        val lastTwoDigits = cleanedPhoneNumber.takeLast(2)

        // Generate the OTP by concatenating the first two digits and the last two digits
        val generatedOTP = "$firstTwoDigits$lastTwoDigits"

        // Update the value of the OTP MutableState
        OTP.value = generatedOTP

        return generatedOTP
    }

}