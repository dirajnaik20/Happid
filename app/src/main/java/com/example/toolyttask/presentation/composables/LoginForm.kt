package com.example.toolyttask.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginForm(
    getPhoneNumber: () -> MutableState<String>,
    updatePhoneNumber: (String) -> Unit,
    requestOTP: () -> Unit,
    onDismissRequest: () -> Unit,
    isRequestOTPButtonClicked: () -> Boolean,
    getFetchedOTP: () -> String

) {

    if (isRequestOTPButtonClicked()) {
        OTPDialogueBox(
            onDismissRequest = onDismissRequest,
            getFetchedOTP = getFetchedOTP
        )
    }

    val phoneNumber: MutableState<String> = getPhoneNumber()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .padding(20.dp)
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .weight(0.5f)
                    .background(Color.Red),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .weight(0.3F),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "",
                        modifier = Modifier
                    )
                    Text(text = "+91")

                }

                OutlinedTextField(
                    value = phoneNumber.value,
                    onValueChange = { typed ->
                        updatePhoneNumber(typed)
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    label = {

                        Text(text = "00000 00000")

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.7F)
                )

            }

            Button(
                onClick = {
                    requestOTP()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(text = "Request OTP")
            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .padding(20.dp, 0.dp, 20.dp, 40.dp)
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.3F)
                    .background(Color.Blue),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .width(150.dp)
                )
                Text(
                    text = "Login With",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp)

                )
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .width(150.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.3F)
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Red),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier
                            .weight(0.5F),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(imageVector = Icons.Default.AccountBox, contentDescription = "")
                        Text(text = "Google")
                    }
                    Row(
                        modifier = Modifier
                            .weight(0.5F),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(imageVector = Icons.Default.AccountBox, contentDescription = "")
                        Text(text = "Facebook")
                    }

                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "By Creating Passcode You Agree With Our")
                Row {
                    Text(
                        text = "Terms and Conditions",
                        color = Color.Red
                    )
                    Text(
                        text = "And",
                        modifier = Modifier
                            .padding(3.dp, 0.dp, 3.dp, 0.dp)
                    )
                    Text(
                        text = "Privacy Policies",
                        color = Color.Red
                    )

                }

            }


        }

    }
}