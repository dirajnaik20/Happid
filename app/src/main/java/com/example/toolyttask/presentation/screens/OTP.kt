package com.example.toolyttask.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.toolyttask.presentation.composables.OTPForm
import com.example.toolyttask.presentation.composables.TopNavigationBar
import com.example.toolyttask.presentation.navigation.NavigationItem

@Composable
fun OTP(
    navController: NavController,
    getSavedNumber: () -> String,
    getOtpDigitList:()->MutableList<String>,
    updateDigit:(Int,String)->Unit
){

    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {

        TopNavigationBar(navigateBackStack = {
            navController.popBackStack()
        })
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(Color.Green),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {

                Text(
                    text = "Enter Your Verification Code",
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "We Have Sent The Code Verification to Your Mobile Number",
                    fontSize = 20.sp,
                )

            }


        }

        OTPForm(
            getSavedNumber=getSavedNumber,
            updateDigit=updateDigit,
            getOtpDigitList = getOtpDigitList,
            navigateToProfile = {
                navController.navigate(NavigationItem.Profile.route)
            }

        )

    }

}