package com.example.first.data

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 22:07 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
import androidx.work.WorkInfo
import kotlinx.coroutines.flow.Flow

interface BluromaticRepository {
    val outputWorkInfo: Flow<WorkInfo>
    fun applyBlur(blurLevel: Int)
    fun cancelWork()
}