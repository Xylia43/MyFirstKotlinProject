package com.example.first.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 14:33 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
@Entity(tableName = "Schedule")
data class BusSchedule (
    @PrimaryKey(autoGenerate = true)
    val id: Int=1,
    @NonNull
    @ColumnInfo(name = "stop_name")
    val stopName: String,
    @NonNull
    @ColumnInfo(name = "arrival_time")
    val arrivalTimeInMillis: Int
)