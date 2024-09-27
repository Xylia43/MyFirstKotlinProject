package com.example.first.fake

import com.example.first.model.MarsPhoto

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/27 14:43 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
object FakeDataSource {
    const val idOne = "img1"
    const val idTwo = "img2"
    const val imgOne = "url.1"
    const val imgTwo = "url.2"
    val photosList = listOf(
        MarsPhoto(
            id = idOne ,
            imgSrc = imgOne
        ) ,
        MarsPhoto(
            id = idTwo ,
            imgSrc = imgTwo
        )
    )
}