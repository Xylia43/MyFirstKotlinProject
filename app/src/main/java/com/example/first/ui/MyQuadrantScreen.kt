package com.example.first.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
 * @date: 2024/9/24 00:31 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
@Composable
fun MyQuadrantScreen() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.third_title) ,
                description = stringResource(R.string.third_description) ,
                backgroundColor = Color(0xFFB69DF8) ,
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.fourth_title) ,
                description = stringResource(R.string.fourth_description) ,
                backgroundColor = Color(0xFFF6EDFF) ,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.first_title) ,
                description = stringResource(R.string.first_description) ,
                backgroundColor = Color(0xFFEADDFF) ,
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.second_title) ,
                description = stringResource(R.string.second_description) ,
                backgroundColor = Color(0xFFD0BCFF) ,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.third_title) ,
                description = stringResource(R.string.third_description) ,
                backgroundColor = Color(0xFFB69DF8) ,
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.fourth_title) ,
                description = stringResource(R.string.fourth_description) ,
                backgroundColor = Color(0xFFF6EDFF) ,
                modifier = Modifier.weight(1f)
            )
        }

    }
}
@Composable
fun ComposableInfoCard(
    modifier: Modifier = Modifier ,
    backgroundColor: Color ,
    title: String ,
    description: String
) {
    Column(
        modifier = modifier
            .background(backgroundColor)
            .padding(16.dp)
            .fillMaxSize() ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title ,
            Modifier.padding(16.dp) ,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description ,
            textAlign = TextAlign.Justify
        )

    }
}
@Preview(showBackground = true)
@Composable
fun MyQuadrantScreenPreview() {
    FirstTheme(darkTheme = true) {
        MyQuadrantScreen()

    }
}