package com.example.first.data

import com.example.first.network.MarsApiService
import com.example.first.network.MarsPhoto

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/27 13:34 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}
class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return marsApiService.getPhotos()
    }
}