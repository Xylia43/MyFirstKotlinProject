package com.example.first.data

import com.example.first.network.MarsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/27 13:52 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
interface AmphibiansAppContainer {
    val amphibiansRepository: MarsPhotosRepository
}
class AmphAppContainer : AmphibiansAppContainer {

    private val baseUrl =
        "https://android-kotlin-fun-mars-server.appspot.com/amphibians/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
    override val amphibiansRepository: MarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(retrofitService)
    }

}
