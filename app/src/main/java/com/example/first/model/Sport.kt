package com.example.first.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/25 20:38 Wed
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
data class Sport(
    val id: Int ,
    @StringRes val titleResourceId: Int ,
    @StringRes val subtitleResourceId: Int ,
    val playerCount: Int ,
    val olympic: Boolean ,
    @DrawableRes val imageResourceId: Int ,
    @DrawableRes val sportsImageBanner: Int ,
    @StringRes val sportDetails: Int
)
