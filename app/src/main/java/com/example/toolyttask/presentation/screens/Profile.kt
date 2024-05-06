package com.example.toolyttask.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.toolyttask.presentation.composables.LoginForm
import com.example.toolyttask.presentation.composables.ProfileForm

@Composable
fun Profile(
    navController: NavHostController,
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 40.dp, 0.dp, 0.dp)
                .height(75.dp)
                .background(Color.Blue),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
                    .size(45.dp)
                    .background(Color.White)
                    .clickable {

                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back-button",
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }

            Text(
                text = "Create Profile",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(100.dp, 0.dp, 0.dp, 0.dp)
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
                    .size(150.dp)
                    .background(Color.White)
                    .clickable {

                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "back-button",
                    tint = Color.Black,
                    modifier = Modifier.size(150.dp)
                )
            }

        }

        ProfileForm(
            getFirstName = getFirstName,
            updateFirstName = updateFirstName,
            getLastName = getLastName,
            updateLastName = updateLastName,
            getPhoneNumber = getPhoneNumber,
            updatePhoneNumber = updatePhoneNumber,
            getPostCode = getPostCode,
            updatePostCode = updatePostCode,
            submitForm=submitForm

        )

    }

}