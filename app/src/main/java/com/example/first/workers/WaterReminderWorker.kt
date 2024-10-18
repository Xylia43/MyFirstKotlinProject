package com.example.first.workers

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/18 16:49 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.first.R

class WaterReminderWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {

        val plantName = inputData.getString(nameKey)

        makePlantReminderNotification(
            applicationContext.resources.getString(R.string.time_to_water, plantName),
            applicationContext
        )

        return Result.success()
    }

    companion object {
        const val nameKey = "NAME"
    }
}