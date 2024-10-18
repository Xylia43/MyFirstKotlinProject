package com.example.first.data

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/18 16:53 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */

import android.content.Context

interface WaterMeAppContainer {
    val waterRepository : WaterRepository
}

class WmAppContainer(context: Context) : WaterMeAppContainer {
    override val waterRepository = WorkManagerWaterRepository(context)
}