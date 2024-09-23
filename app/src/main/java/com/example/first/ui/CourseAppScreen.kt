package com.example.first.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.first.R

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/24 01:23 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
/**
 * Build a course app
 */
data class Topic(
    @StringRes val courseNameId: Int ,
    val courseComNum: Int ,
    @DrawableRes val coursePicId: Int ,

    )
object CourseDataSource {
    val topics = listOf(
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.crafts, 121, R.drawable.crafts),
        Topic(R.string.business, 78, R.drawable.business),
        Topic(R.string.culinary, 118, R.drawable.culinary),
        Topic(R.string.design, 423, R.drawable.design),
        Topic(R.string.fashion, 92, R.drawable.fashion),
        Topic(R.string.film, 165, R.drawable.film),
        Topic(R.string.gaming, 164, R.drawable.gaming),
        Topic(R.string.drawing, 326, R.drawable.drawing),
        Topic(R.string.lifestyle, 305, R.drawable.lifestyle),
        Topic(R.string.music, 212, R.drawable.music),
        Topic(R.string.painting, 172, R.drawable.painting),
        Topic(R.string.photography, 321, R.drawable.photography),
        Topic(R.string.tech, 118, R.drawable.tech)
    )
}
@Composable
fun CourseCard(courseitem: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier.height(68.dp)) {
        Row {
            Image(
                painter = painterResource(courseitem.coursePicId) ,
                contentDescription = stringResource(courseitem.courseNameId) ,
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp),
                contentScale = ContentScale.FillBounds
            )
            Column {
                Text(
                    text = LocalContext.current.getString(courseitem.courseNameId),
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.ic_grain) ,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                    )
                    Text(
                        text = courseitem.courseComNum.toString(),
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 16.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

        }
    }
}
@Composable
fun CourseList(couritemList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(couritemList) {
            //For each affirmation in the list, call the AffirmationCard() composable.
            // Pass it the affirmation and a Modifier object with the padding attribute set to 8.dp.
                topicItem -> CourseCard(
            courseitem = topicItem,
            modifier = Modifier.padding(8.dp)
        )
        }
    }
}