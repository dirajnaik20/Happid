package com.example.toolyttask.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.toolyttask.R
import com.example.toolyttask.ui.theme.fontFamilyRobotoBold

@Composable
fun LoginWith(){


    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .weight(0.5f)
                .height(70.dp)
                .padding(5.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(colorResource(id = R.color.light_orange_2)),
            contentAlignment = Alignment.Center
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)
                )

                Text(
                    text = "Google",
                    fontFamily = fontFamilyRobotoBold,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
            }

        }

        Box(
            modifier = Modifier
                .weight(0.5f)
                .height(70.dp)
                .padding(5.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(colorResource(id = R.color.light_orange_2))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)
                )

                Text(
                    text = "Facebook",
                    fontFamily = fontFamilyRobotoBold,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
            }

        }

    }

}