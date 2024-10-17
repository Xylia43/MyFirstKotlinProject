package com.example.first.data

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 22:05 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */

import android.content.Context

interface BlurAppContainer {
    val bluromaticRepository: BluromaticRepository
}

class BlurDefaultAppContainer(context: Context) : BlurAppContainer {
    override val bluromaticRepository = WorkManagerBluromaticRepository(context)
}