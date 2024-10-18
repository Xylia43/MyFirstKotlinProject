package com.example.first.data

import android.content.Context

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/18 18:35 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
/**
 * App container for Dependency injection.
 */
interface JuiceAppContainer {
    val trackerRepository: JuiceRepository
}
/**
 * [AppContainer] implementation that provides instance of [JuiceRoomRepository]
 */
class JuiceAppDataContainer(private val context: Context) : JuiceAppContainer {
    /**
     * Implementation for [JuiceRepository]
     */
    override val trackerRepository: JuiceRepository by lazy {
        JuiceRoomRepository(JuiceAppDatabase.getDatabase(context).juiceDao())
    }
}