package com.example.first

import android.app.Application
import com.example.first.data.AmphAppContainer
import com.example.first.data.AmphibiansAppContainer
import com.example.first.data.AppDataContainer
import com.example.first.data.BusCcheduleContainer
import com.example.first.data.DefaultAppContainer
import com.example.first.data.InvAppContainer
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
    lateinit var marsContainer: MarsAppContainer
    lateinit var amphContainer: AmphibiansAppContainer
    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var invContainer: InvAppContainer
    lateinit var busContainer: BusCcheduleContainer

    override fun onCreate() {
        super.onCreate()
        marsContainer = DefaultAppContainer()
        amphContainer = AmphAppContainer()
        invContainer = AppDataContainer(this)
        busContainer = BusCcheduleContainer(this)
    }
}