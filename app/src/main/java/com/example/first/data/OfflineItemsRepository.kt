package com.example.first.data

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/1 00:07 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
import kotlinx.coroutines.flow.Flow

class OfflineItemsRepository(private val itemDao: InvItemDao) : InvItemsRepository {
    override fun getAllItemsStream(): Flow<List<InventoryItem>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<InventoryItem?> = itemDao.getItem(id)

    override suspend fun insertItem(item: InventoryItem) = itemDao.insert(item)

    override suspend fun deleteItem(item: InventoryItem) = itemDao.delete(item)

    override suspend fun updateItem(item: InventoryItem) = itemDao.update(item)
}