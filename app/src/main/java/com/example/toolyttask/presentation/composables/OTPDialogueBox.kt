package com.example.toolyttask.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.toolyttask.R
import com.example.toolyttask.ui.theme.fontFamilyRobotoBold
import com.example.toolyttask.ui.theme.fontFamilyRobotoLight

@Composable
fun OTPDialogueBox(
    onDismissRequest: () -> Unit,
    getFetchedOTP: () -> String
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
            ,
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.5F)
                ) {

                    Text(
                        text = "Your Confirmation Code is Below - Enter it and We'll Help You Get Signed In",
                        fontFamily = fontFamilyRobotoLight,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center),
                        textAlign = TextAlign.Center,
                    )

                }

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.5F)
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

                            Text(
                                text = getFetchedOTP(),
                                fontFamily = fontFamilyRobotoBold,
                                fontSize = 30.sp,
                                modifier = Modifier
                                    .padding(start = 5.dp)
                            )
                        }

                    }
                }


            }


        }
    }
}