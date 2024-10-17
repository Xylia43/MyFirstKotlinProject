package com.example.first.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * @className: BusScheduleDao
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/12 22:50 Sat
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
@Dao
interface BusScheduleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: BusSchedule)

    @Update
    suspend fun update(item: BusSchedule)

    @Delete
    suspend fun delete(item: BusSchedule)

    @Query("SELECT * from Schedule WHERE stop_name = :name")
    fun getSchedule(name: String): Flow<List<BusSchedule>>

    @Query("SELECT * from Schedule ORDER BY stop_name ASC")
    fun getAllSchedules(): Flow<List<BusSchedule>>
}