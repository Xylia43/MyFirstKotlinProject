package com.example.first.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
 * @date: 2024/9/24 00:35 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
@Composable
fun MyProfileCompose(modifier: Modifier = Modifier , image: Int , string: String , name: String) {
    Column(
        modifier = modifier.fillMaxWidth() ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image) ,
            contentDescription = "mememe" ,
            Modifier.width(100.dp)
        )
        Text(
            text = string ,
            fontSize = 26.sp
        )
        Text(
            text = name ,
            fontSize = 20.sp
        )

    }
}

@Composable
fun MyContactCompose(modifier: Modifier = Modifier , info: String) {
    Column(
        modifier = modifier.fillMaxWidth() ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground) ,
                contentDescription = null ,
                Modifier.width(30.dp)
            )
            Text(text = info , fontSize = 16.sp)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground) ,
                contentDescription = null ,
                Modifier.width(30.dp)
            )
            Text(text = info , fontSize = 16.sp)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground) ,
                contentDescription = null ,
                Modifier.width(30.dp)
            )
            Text(text = info , fontSize = 16.sp)
        }

    }

}

@Composable
fun MyBusinessCard() {
    Column(
        Modifier.fillMaxSize() ,
        verticalArrangement = Arrangement.Center
    ) {
        MyProfileCompose(Modifier , R.drawable.hello , "FULL NAME" , "Yan")
        Spacer(Modifier.height(50.dp))
        MyContactCompose(info = "+44 07529209272")
    }

}
@Preview(showBackground = true)
@Composable
fun MyBusinessCardPreview() {
    FirstTheme(darkTheme = true) {
        MyBusinessCard()

    }
}