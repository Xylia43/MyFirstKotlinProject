package com.example.first.data

import kotlinx.coroutines.flow.Flow

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/18 18:39 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
class JuiceRoomRepository(private val juiceDao: JuiceDao) : JuiceRepository {
    override val juicesStream: Flow<List<Juice>> = juiceDao.getAll()
    override fun getJuiceStream(id: Long): Flow<Juice?> = juiceDao.get(id)
    override suspend fun addJuice(juice: Juice) = juiceDao.insert(juice)
    override suspend fun deleteJuice(juice: Juice) = juiceDao.delete(juice)
    override suspend fun updateJuice(juice: Juice) = juiceDao.update(juice)
}