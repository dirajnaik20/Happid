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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.toolyttask.presentation.composables.ProfileForm
import com.example.toolyttask.R
import com.example.toolyttask.ui.theme.fontFamilyRobotoBold

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
                .padding(top = 40.dp)
                .height(75.dp)
                .background(colorResource(id = R.color.light_orange_1)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
                    .size(45.dp)
                    .background(Color.Transparent)
                    .clickable {

                        navController.popBackStack()

                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_left_arrow),
                    contentDescription = "back-button",
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp)
                )
            }

            Text(
                text = "Create Profile",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 90.dp),
                fontFamily = fontFamilyRobotoBold,
                fontSize = 18.sp
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(225.dp)
                .background(colorResource(id = R.color.light_orange_1)),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .padding(top = 0.dp)
                        .clip(CircleShape)
                        .size(125.dp)
                        .background(colorResource(id = R.color.light_orange_3))
                        .clickable {

                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_camera),
                        contentDescription = "back-button",
                        tint = colorResource(id = R.color.light_orange_4),
                        modifier = Modifier.size(50.dp)
                    )
                }

                Text(
                    text = "Set Profile",
                    modifier = Modifier
                        .padding(top = 3.dp)
                    ,
                    fontFamily = fontFamilyRobotoBold,
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.gray_1)
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
            submitForm = submitForm

        )

    }

}