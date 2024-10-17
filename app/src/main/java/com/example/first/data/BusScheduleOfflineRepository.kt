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

class BusScheduleOfflineRepository(private val itemDao: BusScheduleDao) : BusScheduleRepository {
    override fun getAllItemsStream(): Flow<List<BusSchedule>> = itemDao.getAllSchedules()

    override fun getItemStream(name: String): Flow<List<BusSchedule>> = itemDao.getSchedule(name)

    override suspend fun insertItem(item: BusSchedule) = itemDao.insert(item)

    override suspend fun deleteItem(item: BusSchedule) = itemDao.delete(item)

    override suspend fun updateItem(item: BusSchedule) = itemDao.update(item)
}