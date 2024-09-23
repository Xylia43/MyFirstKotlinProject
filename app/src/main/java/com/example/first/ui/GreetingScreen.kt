package com.example.first.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.first.R
import com.example.first.ui.theme.FirstTheme

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/24 00:25 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
@Composable
fun GreetingScreen(name: String , modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_launcher_background)
    Column() {
        Image(
            painter = image ,
            contentDescription = null ,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = name ,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.Start)
                .width(150.dp),
            fontSize = 24.sp,
            textAlign = TextAlign.End

        )
        Text(
            text = "first paragraph xxxx" ,
            modifier = modifier.padding(16.dp , 0.dp , 16.dp , 0.dp) ,
            textAlign = TextAlign.Justify
        )
        Text(
            text = "second paragraph" ,
            modifier = modifier.padding(16.dp) ,
            textAlign = TextAlign.Justify
        )

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstTheme(darkTheme = true) {
        GreetingScreen("Android")

    }
}