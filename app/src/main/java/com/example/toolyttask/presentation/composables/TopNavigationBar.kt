package com.example.toolyttask.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.toolyttask.R

@Composable
fun TopNavigationBar(
    navigateBackStack:() -> Unit
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 40.dp, 0.dp, 0.dp)
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
                .clickable {
                    navigateBackStack()

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



    }

}