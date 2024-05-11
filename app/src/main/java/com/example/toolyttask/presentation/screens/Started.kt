package com.example.toolyttask.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.toolyttask.presentation.navigation.NavigationItem
import com.example.toolyttask.R
import com.example.toolyttask.ui.theme.fontFamilyRobotoBold
import com.example.toolyttask.ui.theme.fontFamilyRobotoLight

@Composable
fun Started(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(colorResource(id = R.color.light_orange_1)),
            contentAlignment = Alignment.Center

        ) {
            Box{
                Image(painter = painterResource(id = R.drawable.ic_hapid),
                    contentDescription ="" )
            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 30.dp, end = 30.dp, bottom = 40.dp, top = 20.dp),
                verticalArrangement = Arrangement.spacedBy(0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Best Marketplace",
                    fontFamily = fontFamilyRobotoBold,
                    fontSize = 30.sp
                )

                Text(
                    modifier = Modifier
                        .padding(top = 30.dp),
                    text = "O On-Time Departures. Pay just for your seat. No Refusal from our end. Spacious & Comfortable Seating. Female passengers safety standards. Onboard Refreshments. Cab Tracking through Maps",
                    fontFamily = fontFamilyRobotoLight,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    softWrap = true
                )

                Button(
                    onClick = {
                              navController.navigate(NavigationItem.Login.route)
                    },
                    modifier = Modifier
                        .padding(top = 100.dp)
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
                            text = "Get Started",
                            fontFamily = fontFamilyRobotoBold,
                            fontWeight = FontWeight.Bold
                        )

                    }


                }

            }


        }


    }


}