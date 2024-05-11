package com.example.toolyttask.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.toolyttask.presentation.composables.LandingPageLogo
import com.example.toolyttask.presentation.navigation.NavigationItem
import com.example.toolyttask.ui.theme.fontFamilyRobotoBold



@Composable
fun Landing(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { navController.navigate(NavigationItem.Started.route) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 40.dp)
                .weight(0.6f)
        ) {

            LandingPageLogo()

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 40.dp)
                .weight(0.4f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Find Nearest Local Market Place",
                fontFamily = fontFamilyRobotoBold,
                fontSize = 35.sp,
                textAlign = TextAlign.Center

            )

        }

    }

}