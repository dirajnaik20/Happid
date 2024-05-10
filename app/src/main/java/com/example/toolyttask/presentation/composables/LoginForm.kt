package com.example.toolyttask.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toolyttask.R
import com.example.toolyttask.ui.theme.fontFamilyRobotoBold

@OptIn(ExperimentalMaterial3Api::class)
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
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, bottom = 40.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .padding(top = 30.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Row(
                        modifier = Modifier
                            .weight(0.3F)
                            .clip(RoundedCornerShape(10.dp))
                            .height(TextFieldDefaults.MinHeight)
                            .padding(end = 10.dp)
                            .background(colorResource(id = R.color.light_orange_1)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_india_flag),
                            contentDescription = ""
                        )
                        Text(
                            text = "+91",
                            fontFamily = fontFamilyRobotoBold,
                            color = colorResource(id = R.color.gray_1),
                            fontSize = 18.sp
                        )

                    }

                    OutlinedTextField(
                        value = phoneNumber.value,
                        onValueChange = { typed ->
                            updatePhoneNumber(typed)
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.7f),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = colorResource(id = R.color.light_orange_1),
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = colorResource(id = R.color.light_orange_4)
                        ),
                        placeholder = {
                            Text(
                                text = "0 0 0 0 0  0 0 0 0 0",
                                fontFamily = fontFamilyRobotoBold,
                                color = colorResource(id = R.color.gray_1),
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp
                            )
                        }
                    )


                }

                Button(
                    onClick = {
                        requestOTP()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(TextFieldDefaults.MinHeight),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.button_indigo)
                    ),
                    shape = RoundedCornerShape(5.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Request OTP",
                            fontFamily = fontFamilyRobotoBold,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                    }

                }


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
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
                    fontFamily = fontFamilyRobotoBold,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp)

                )
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .width(150.dp)
                )
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            LoginWith()

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "By Creating Passcode You Agree With Our",
                    fontFamily = fontFamilyRobotoBold
                )

                Row {
                    Text(
                        text = "Terms and Conditions",
                        color = Color.Red,
                        fontFamily = fontFamilyRobotoBold
                    )
                    Text(
                        text = "And",
                        modifier = Modifier
                            .padding(3.dp, 0.dp, 3.dp, 0.dp),
                        fontFamily = fontFamilyRobotoBold
                    )
                    Text(
                        text = "Privacy Policy",
                        color = Color.Red,
                        fontFamily = fontFamilyRobotoBold
                    )

                }

            }


        }


    }
}