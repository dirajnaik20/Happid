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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.toolyttask.presentation.composables.OTPForm
import com.example.toolyttask.presentation.composables.TopNavigationBar
import com.example.toolyttask.presentation.navigation.NavigationItem
import com.example.toolyttask.ui.theme.fontFamilyRobotoBold
import com.example.toolyttask.R

@Composable
fun OTP(
    navController: NavController,
    getDigit:()-> MutableState<String>,
    updateDigit:(String)->Unit,
    compareOTP:()-> Boolean,
    getPhoneNumberToEdit: () -> MutableState<String>,
    updateEditedPhoneNumber: (String) -> Unit
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
                .background(colorResource(id = R.color.light_orange_1)),
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
                    fontFamily = fontFamilyRobotoBold,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "We Have Sent The Code Verification to Your Mobile Number",
                    fontSize = 18.sp,
                    fontFamily = fontFamilyRobotoBold,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.gray_1),
                    modifier = Modifier
                        .padding(top=5.dp)
                )

            }


        }

        OTPForm(
            updateDigit=updateDigit,
            getDigit= getDigit,
            navigateToProfile = {
                navController.navigate(NavigationItem.Profile.route)
            },
            compareOTP = compareOTP,
            getPhoneNumberToEdit = getPhoneNumberToEdit,
            updateEditedPhoneNumber = updateEditedPhoneNumber

        )

    }

}