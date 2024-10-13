package com.example.first.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @className: first
 * @desc: Entity data class represents a single row in the database.
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/1 00:05 Tue
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
/**
 * Entity data class represents a single row in the database.
 */
@Entity(tableName = "items")
data class InventoryItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)