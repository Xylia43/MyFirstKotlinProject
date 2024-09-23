package com.example.first.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.first.R

/**
 * @className: first
 * @desc:art space app
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/24 01:16 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp , vertical = 50.dp)
            .verticalScroll(rememberScrollState()) ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center
    ) {
        when (currentStep) {
            1 -> {
                ArtTextAndImage(
                    titleId = R.string.pic_title ,
                    desId = R.string.pic_des ,
                    drawableResourceId = R.drawable.gopr0074 ,
                    contentDescriptionResourceId = R.string.lemonTree ,
                    modifier = modifier
                )
            }

            2 -> {
                ArtTextAndImage(
                    titleId = R.string.selectLemon ,
                    desId = R.string.tap2Restart ,
                    drawableResourceId = R.drawable.lemon_tree ,
                    contentDescriptionResourceId = R.string.lemonTree ,
                    modifier = modifier
                )
            }

            3 -> {
                ArtTextAndImage(
                    titleId = R.string.selectLemon ,
                    desId = R.string.selectLemon ,
                    drawableResourceId = R.drawable.hello ,
                    contentDescriptionResourceId = R.string.lemonTree ,
                    modifier = modifier
                )
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .size(48.dp)
        ) {
            Button(
                onClick = { currentStep = 1 } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.art_btn)
                )

            ) {
                Text(stringResource(id = R.string.pic_previous))

            }
            Button(
                onClick = { currentStep = 2 } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.art_btn)
                ) , modifier = Modifier.align(alignment = Alignment.CenterEnd)
            ) {
                Text(stringResource(id = R.string.pic_next))

            }

        }
    }
}

@Composable
fun ArtTextAndImage(
    @StringRes titleId: Int ,
    @StringRes desId: Int ,
    @DrawableRes drawableResourceId: Int ,
    @StringRes contentDescriptionResourceId: Int ,
    modifier: Modifier
) {
    Image(
        painter = painterResource(id = drawableResourceId) ,
        contentDescription = stringResource(id = contentDescriptionResourceId) ,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth() ,
        contentScale = ContentScale.FillBounds
    )
    Spacer(modifier = Modifier.height(30.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.art_text_background))
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(id = titleId) ,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.Start) ,
            fontSize = 20.sp
        )
        Text(
            text = stringResource(id = desId) ,
            modifier = Modifier
                .align(alignment = Alignment.Start) ,
            fontWeight = FontWeight.Bold
        )
    }
}
