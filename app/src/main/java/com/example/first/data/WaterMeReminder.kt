package com.example.first.data

import androidx.annotation.StringRes
import java.util.concurrent.TimeUnit
/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/18 16:46 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
/**
 * Data class for representing the information required for reminder dialogs items.
 * */
data class Reminder(
    @StringRes val durationRes: Int,
    val duration: Long,
    val unit: TimeUnit,
    val plantName: String
)