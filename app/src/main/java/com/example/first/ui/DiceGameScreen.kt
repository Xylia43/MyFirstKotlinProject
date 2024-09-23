package com.example.first.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.first.R
import com.example.first.ui.theme.FirstTheme

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/24 00:44 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.

 */
/************roll dice*************
 * roll dice
 */
@Composable
fun DiceWithButtonAndImage(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
// pass the modifer to make efficial, because the composable function may re composition
// again so create one inside it is not efficiency
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource) ,
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { result = (1..6).random() } ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(red = 180 , green = 100 , blue = 100)
            )
        ) {
            Text(stringResource(id = R.string.roll))

        }

    }

}
@Preview(showBackground = true)
@Composable
fun DiceGamePreview() {
    FirstTheme(darkTheme = true) {
        DiceWithButtonAndImage()

    }
}