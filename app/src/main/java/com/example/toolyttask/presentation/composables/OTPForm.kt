package com.example.toolyttask.presentation.composables

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toolyttask.R
import com.example.toolyttask.ui.theme.fontFamilyRobotoBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OTPForm(
    getDigit: () -> MutableState<String>,
    updateDigit: (String) -> Unit,
    navigateToProfile: () -> Unit,
    compareOTP: () -> Boolean,
    getPhoneNumberToEdit: () -> MutableState<String>,
    updateEditedPhoneNumber: (String) -> Unit,

    ) {

    val context = LocalContext.current
    val phoneNumber: MutableState<String> = getPhoneNumberToEdit()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {
//                Text(text = getSavedNumber())
//                Icon(imageVector = Icons.Default.Person, contentDescription = "")
                OutlinedTextField(
                    modifier = Modifier
                        .width(200.dp)
                        .height(55.dp)
                        .padding(0.dp),
                    value = phoneNumber.value,
                    onValueChange = updateEditedPhoneNumber,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = TextStyle(
                        fontFamily = fontFamilyRobotoBold,
                        fontSize = 16.sp
                    ),
                    prefix = {
                        Text(
                            text = "+91",
                            fontSize = 16.sp,
                            fontFamily = fontFamilyRobotoBold,
                            color = Color.Black
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_edit),
                            contentDescription = "",
                            modifier = Modifier
                                .size(18.dp)
                                .padding(0.dp),
                            tint = Color.Black
                        )
                    }
                )
            }

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )


            DigitsInput(
                getDigit = getDigit,
                updateDigit = updateDigit
            )

            Button(
                onClick = {
                    if (compareOTP()) {
                        Toast.makeText(context, "LOGIN SUCCESS", Toast.LENGTH_LONG).show()
                        navigateToProfile()
                    } else {
                        Toast.makeText(context, "ENTERED OTP INCORRECT", Toast.LENGTH_LONG).show()
                    }


                },
                modifier = Modifier
                    .padding(10.dp, 50.dp)
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
                        text = "Submit",
                        fontFamily = fontFamilyRobotoBold,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                }


            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top=50.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {

                Text(
                    text = "Didn't Receive OTP?",
                    fontFamily = fontFamilyRobotoBold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .clickable {

                        }
                    ,
                    text = "Resend",
                    fontFamily = fontFamilyRobotoBold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.light_orange_4)
                )

            }


        }



    }
}

