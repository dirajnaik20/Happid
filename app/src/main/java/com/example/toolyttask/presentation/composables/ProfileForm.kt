package com.example.toolyttask.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toolyttask.R
import com.example.toolyttask.ui.theme.fontFamilyRobotoBold
import com.example.toolyttask.ui.theme.fontFamilyRobotoLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileForm(
    getFirstName: () -> MutableState<String>,
    updateFirstName: (String) -> Unit,
    getLastName: () -> MutableState<String>,
    updateLastName: (String) -> Unit,
    getPhoneNumber: () -> MutableState<String>,
    updatePhoneNumber: (String) -> Unit,
    getPostCode: () -> MutableState<String>,
    updatePostCode: (String) -> Unit,
    submitForm: () -> Unit
) {

    val firstName: MutableState<String> = getFirstName()
    val lastName: MutableState<String> = getLastName()
    val phoneNumber: MutableState<String> = getPhoneNumber()
    val postCode: MutableState<String> = getPostCode()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column {
                Text(
                    modifier = Modifier
                        .padding(bottom = 10.dp),
                    text = "First Name",
                    fontFamily = fontFamilyRobotoLight,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = firstName.value,
                    onValueChange = { typed ->
                        updateFirstName(typed)
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = colorResource(id = R.color.light_orange_1),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = colorResource(id = R.color.light_orange_4)
                    )
                )
            }

            Column {
                Text(
                    modifier = Modifier
                        .padding(bottom = 10.dp),
                    text = "Last Name",
                    fontFamily = fontFamilyRobotoLight,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = lastName.value,
                    onValueChange = { typed ->
                        updateLastName(typed)
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = colorResource(id = R.color.light_orange_1),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = colorResource(id = R.color.light_orange_4)
                    )
                )

            }

            Column {
                Text(
                    modifier = Modifier
                        .padding(bottom = 10.dp),
                    text = "Phone",
                    fontFamily = fontFamilyRobotoLight,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = phoneNumber.value,
                    onValueChange = { typed ->
                        updatePhoneNumber(typed)
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = colorResource(id = R.color.light_orange_1),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = colorResource(id = R.color.light_orange_4)
                    )
                )
            }

            Button(
                onClick = {
                },
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .height(TextFieldDefaults.MinHeight),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.light_orange_4)
                ),
                shape = RoundedCornerShape(5.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ) {
                    Text(
                        text = "Pick Your Current Location",
                        fontFamily = fontFamilyRobotoLight,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        modifier = Modifier
                            .size(25.dp),
                        painter = painterResource(id = R.drawable.ic_gps),
                        contentDescription = ""
                    )

                }


            }

            Text(
                text = "Or",
                fontFamily = fontFamilyRobotoLight,
                fontWeight = FontWeight.Bold
            )

            Column {
                Text(
                    modifier = Modifier
                        .padding(bottom = 10.dp),
                    text = "Post Code",
                    fontFamily = fontFamilyRobotoLight,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = postCode.value,
                    onValueChange = { typed ->
                        updatePostCode(typed)
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Select Post Code Or Address",
                            fontFamily = fontFamilyRobotoBold,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.gray_2)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = colorResource(id = R.color.light_orange_1),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = colorResource(id = R.color.light_orange_4)
                    )
                )
            }

            Button(
                onClick = {
                },
                modifier = Modifier
                    .padding(top = 10.dp)
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
                        fontWeight = FontWeight.Bold
                    )

                }


            }


        }

    }

}