package com.example.toolyttask.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.toolyttask.presentation.navigation.NavigationItem

@Composable
fun Landing(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { navController.navigate(NavigationItem.Started.route) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Landing")

    }

}