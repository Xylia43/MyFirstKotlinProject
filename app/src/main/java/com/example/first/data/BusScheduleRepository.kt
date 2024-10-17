package com.example.first.data

import kotlinx.coroutines.flow.Flow

/**
 * @className: first
 * @desc: Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 15:06 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
interface BusScheduleRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<List<BusSchedule>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(name: String): Flow<List<BusSchedule>>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: BusSchedule)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: BusSchedule)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(item: BusSchedule)
}