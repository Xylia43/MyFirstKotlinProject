package com.example.first

import android.app.Application
import com.example.first.data.AmphAppContainer
import com.example.first.data.AmphibiansAppContainer
import com.example.first.data.DefaultAppContainer
import com.example.first.data.MarsAppContainer

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/27 14:05 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
class MarsPhotosApplication : Application()  {
    lateinit var container: MarsAppContainer
    lateinit var amphContainer: AmphibiansAppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
        amphContainer = AmphAppContainer()
    }
}