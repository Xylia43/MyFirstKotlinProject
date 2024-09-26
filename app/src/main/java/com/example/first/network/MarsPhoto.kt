package com.example.first.network

import kotlinx.serialization.Serializable

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/26 23:35 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
@Serializable
data class MarsPhoto(
    val id: String,  val img_src: String
)