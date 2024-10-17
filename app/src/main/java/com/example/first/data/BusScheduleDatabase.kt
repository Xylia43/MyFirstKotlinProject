package com.example.first.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 15:03 Sat
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [BusSchedule::class], version = 1, exportSchema = false)
abstract class BusScheduleDatabase : RoomDatabase() {

    abstract fun BusScheduleDao(): BusScheduleDao

//    companion object {
//        @Volatile
//        private var Instance: BusScheduleDatabase? = null
//
//        fun getDatabase(context: Context): BusScheduleDatabase {
//            // if the Instance is not null, return it, otherwise create a new database instance.
//            return Instance ?: synchronized(this) {
//                Room.databaseBuilder(context, BusScheduleDatabase::class.java, "bus_schedule")
//                    .build()
//                    .also { Instance = it }
//            }
//        }
//    }
    companion object {
        @Volatile
        private var INSTANCE: BusScheduleDatabase? = null

        fun getDatabase(context: Context): BusScheduleDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    BusScheduleDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/bus_schedule.db")
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}