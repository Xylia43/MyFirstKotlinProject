package com.example.first.data

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/18 18:38 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
import kotlinx.coroutines.flow.Flow

interface JuiceRepository {
    val juicesStream: Flow<List<Juice>>

    fun getJuiceStream(id: Long): Flow<Juice?>
    suspend fun addJuice(juice: Juice)
    suspend fun deleteJuice(juice: Juice)
    suspend fun updateJuice(juice: Juice)
}