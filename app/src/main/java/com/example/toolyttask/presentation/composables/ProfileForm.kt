package com.example.toolyttask.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

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
            .background(Color.Yellow)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
                .background(Color.White)
        ) {


            OutlinedTextField(
                value = firstName.value,
                onValueChange = { typed ->
                    updateFirstName(typed)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                label = {

                    Text(text = "First Name")

                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = lastName.value,
                onValueChange = { typed ->
                    updateLastName(typed)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                label = {

                    Text(text = "Last Name")

                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = phoneNumber.value,
                onValueChange = { typed ->
                    updatePhoneNumber(typed)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                label = {

                    Text(text = "Phone Number")

                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            Button(
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "Pick Your Current Location")
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = ""
                    )

                }


            }

            OutlinedTextField(
                value = postCode.value,
                onValueChange = { typed ->
                    updatePostCode(typed)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                label = {

                    Text(text = "Post Code")

                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            Button(
                onClick = {
                    submitForm()
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {

                Text(text = "SUBMIT")

            }


        }

    }

}