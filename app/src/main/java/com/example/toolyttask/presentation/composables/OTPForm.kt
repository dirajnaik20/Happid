package com.example.toolyttask.presentation.composables

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun OTPForm(
    getSavedNumber: () -> String,
    getDigit: () -> MutableState<String>,
    updateDigit: (String) -> Unit,
    navigateToProfile: () -> Unit,
    compareOTP:()-> Boolean

) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
                .background(Color.White)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .background(Color.Red),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = getSavedNumber())
                Icon(imageVector = Icons.Default.Person, contentDescription = "")
            }
//            DigitsInput(
//                getOtpDigitList = getOtpDigitList,
//                updateDigit = updateDigit
//            )

            DigitsInput(
                getDigit = getDigit,
                updateDigit = updateDigit
            )

            Button(
                onClick = {
                    if (compareOTP()){
                        Toast.makeText(context,"LOGIN SUCCESS",Toast.LENGTH_LONG).show()
                        navigateToProfile()
                    }else{
                        Toast.makeText(context,"ENTERED OTP INCORRECT",Toast.LENGTH_LONG).show()
                    }


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(text = "Submit")
            }


        }

    }
}
