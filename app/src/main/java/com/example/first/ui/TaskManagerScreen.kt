package com.example.first.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
 * @date: 2024/9/24 00:29 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
@Composable
fun TaskMangerScreen(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight() ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            painter = image ,
            contentDescription = null ,
            contentScale = ContentScale.Crop
        )
        Text(
            text = "All Task Complete" ,
            Modifier.padding(0.dp , 24.dp , 0.dp , 8.dp) ,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Nice Work!" , fontSize = 16.sp)
    }

}
@Preview(showBackground = true)
@Composable
fun TaskMangerScreenPreview() {
    FirstTheme(darkTheme = true) {
        TaskMangerScreen()

    }
}