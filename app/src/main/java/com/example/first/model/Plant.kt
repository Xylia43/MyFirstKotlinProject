package com.example.first.model

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/18 16:45 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
import android.os.Parcelable
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

/**
 * Data class for representing the information required for each plant card.
 * */
@Parcelize
data class Plant(
    @StringRes val name: Int,
    @StringRes val type: Int,
    @StringRes val description: Int,
    @StringRes val schedule: Int
): Parcelable