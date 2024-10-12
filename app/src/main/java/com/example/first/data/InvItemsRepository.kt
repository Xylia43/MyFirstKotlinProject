package com.example.first.data

import kotlinx.coroutines.flow.Flow

/**
 * @className: first
 * @desc: Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/1 00:06 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
interface InvItemsRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<List<InventoryItem>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<InventoryItem?>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: InventoryItem)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: InventoryItem)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(item: InventoryItem)
}