package com.example.first

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/12 21:53 Sat
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
import android.app.Application
import com.example.first.data.AppDataContainer
import com.example.first.data.InvAppContainer

class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: InvAppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}