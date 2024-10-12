package com.example.first.data

import android.content.Context

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/1 00:03 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
interface InvAppContainer {
    val itemsRepository: InvItemsRepository
}
/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : InvAppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val itemsRepository: InvItemsRepository by lazy {
        OfflineItemsRepository()
    }
}