package com.example.first.network

import com.example.first.model.MarsPhoto
import retrofit2.http.GET

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/26 22:49 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
//private const val BASE_URL =
//    "https://android-kotlin-fun-mars-server.appspot.com/"
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
//    .baseUrl(BASE_URL)
//    .build()

/**
 * A public interface that exposes the [getPhotos] method
 */
interface MarsApiService {
    /**
     * Returns a [List] of [MarsPhoto] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "photos" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}