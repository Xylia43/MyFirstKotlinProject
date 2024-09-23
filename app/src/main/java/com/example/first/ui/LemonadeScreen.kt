package com.example.first.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.first.R
import com.example.first.ui.theme.FirstTheme

/**
 * @className: first
 * @desc:
 *  * Lemonade
 *  * button click practice
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/24 00:46 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
@Composable
fun Lemonade(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    var currentStep by remember { mutableStateOf(1) }
    when (currentStep) {
        1 -> {
            Column(
                modifier = modifier ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_tree) ,
                    contentDescription = stringResource(id = R.string.lemonTree) ,
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            currentStep = 2
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(id = R.string.selectLemon))
            }
        }

        2 -> {
            val squeezetimes = (1..5).random()
            var clicktimes = 0
            Column(
                modifier = modifier ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze) ,
                    contentDescription = stringResource(id = R.string.lemon) ,
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            clicktimes++
                            if (clicktimes >= squeezetimes) {
                                currentStep = 3
                            }
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(id = R.string.squeezeLemon))
            }
        }

        3 -> {
            Column(
                modifier = modifier ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_drink) ,
                    contentDescription = stringResource(id = R.string.glassOfLemonade) ,
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            currentStep = 4
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(id = R.string.tap2Drink))
            }
        }

        4 -> {
            Column(
                modifier = modifier ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_restart) ,
                    contentDescription = stringResource(id = R.string.emptyGlass) ,
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            currentStep = 1
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(id = R.string.tap2Restart))
            }
        }
    }
}

/**
 * lemonade app by official
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun LemonadeApp() {

    var currentStep by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade" ,
                        fontWeight = FontWeight.Bold
                    )
                } ,
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer ,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer ,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer ,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer) ,
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.selectLemon ,
                        drawableResourceId = R.drawable.lemon_tree ,
                        contentDescriptionResourceId = R.string.lemonTree ,
                        onImageClick = {
                            currentStep = 2
                            squeezeCount = (2..4).random()
                        }
                    )
                }

                2 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.squeezeLemon ,
                        drawableResourceId = R.drawable.lemon_squeeze ,
                        contentDescriptionResourceId = R.string.lemon ,
                        onImageClick = {
                            squeezeCount--
                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
                        }
                    )
                }

                3 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.tap2Drink ,
                        drawableResourceId = R.drawable.lemon_drink ,
                        contentDescriptionResourceId = R.string.glassOfLemonade ,
                        onImageClick = {
                            currentStep = 4
                        }
                    )
                }

                4 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.tap2Restart ,
                        drawableResourceId = R.drawable.lemon_restart ,
                        contentDescriptionResourceId = R.string.emptyGlass ,
                        onImageClick = {
                            currentStep = 1
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int ,
    drawableResourceId: Int ,
    contentDescriptionResourceId: Int ,
    onImageClick: () -> Unit ,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center ,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick ,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)) ,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableResourceId) ,
                    contentDescription = stringResource(contentDescriptionResourceId) ,
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width))
                        .height(dimensionResource(R.dimen.button_image_height))
                        .padding(dimensionResource(R.dimen.button_interior_padding))
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Text(
                text = stringResource(textLabelResourceId) ,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    FirstTheme(darkTheme = true) {
        LemonadeApp()
//        Lemonade()

    }
}