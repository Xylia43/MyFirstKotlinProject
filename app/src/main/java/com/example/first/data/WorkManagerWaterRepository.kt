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
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.first.model.Plant
import com.example.first.workers.WaterReminderWorker
import java.util.concurrent.TimeUnit

class WorkManagerWaterRepository(context: Context) : WaterRepository {
    private val workManager = WorkManager.getInstance(context)

    override val plants: List<Plant>
        get() = DataSource.plants

    override fun scheduleReminder(duration: Long, unit: TimeUnit, plantName: String) {
//        var data = workManager.beginUniqueWork(//Blur-O-Matic now only blurs one image at a time.
//            WaterReminderWorker.nameKey ,
//            ExistingWorkPolicy.REPLACE,
//            OneTimeWorkRequest.from(WaterReminderWorker::class.java))
//        val watermeBuilder = OneTimeWorkRequestBuilder<WaterReminderWorker>()
//        watermeBuilder.setInputData(data)

        val data = Data.Builder()
        data.putString(WaterReminderWorker.nameKey, plantName)

        val workRequestBuilder = OneTimeWorkRequestBuilder<WaterReminderWorker>()
            .setInitialDelay(duration, unit)
            .setInputData(data.build())
            .build()

        workManager.enqueueUniqueWork(
            plantName + duration,
            ExistingWorkPolicy.REPLACE,
            workRequestBuilder
        )

    }
}