package com.example.first.data

import android.content.Context

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 15:03 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
interface BusScheduleAppContainer {
    val busRepository: BusScheduleRepository
}
/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class BusCcheduleContainer(private val context: Context) : BusScheduleAppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val busRepository: BusScheduleRepository by lazy {
        BusScheduleOfflineRepository(BusScheduleDatabase.getDatabase(context).BusScheduleDao())
    }
}