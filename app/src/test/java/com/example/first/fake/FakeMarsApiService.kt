package com.example.first.fake

import com.example.first.network.MarsApiService
import com.example.first.model.MarsPhoto

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/27 14:46 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
class FakeMarsApiService: MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}