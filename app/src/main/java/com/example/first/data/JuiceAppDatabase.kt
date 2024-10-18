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
 * @date: 2024/10/18 18:36 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */

@Database(entities = [Juice::class], version = 1)
abstract class JuiceAppDatabase: RoomDatabase() {
    abstract fun juiceDao(): JuiceDao
    companion object {
        @Volatile
        private var INSTANCE: JuiceAppDatabase? = null
        fun getDatabase(context: Context): JuiceAppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, JuiceAppDatabase::class.java, "app_database")
                    // Setting this option in your app's database builder means that Room
                    // permanently deletes all data from the tables in your database when it
                    // attempts to perform a migration with no defined migration path.
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}