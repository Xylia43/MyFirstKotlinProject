package com.example.first.data

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/18 16:47 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
import android.content.Context
import androidx.work.WorkManager
import com.example.first.model.Plant
import java.util.concurrent.TimeUnit

class WorkManagerWaterRepository(context: Context) : WaterRepository {
    private val workManager = WorkManager.getInstance(context)

    override val plants: List<Plant>
        get() = DataSource.plants

    override fun scheduleReminder(duration: Long, unit: TimeUnit, plantName: String) {}
}