package com.example.first.workers
import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.first.DELAY_TIME_MILLIS
import com.example.first.OUTPUT_PATH
import com.example.first.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.File
/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 23:19 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
/**
 * Cleans up temporary files generated during blurring process
 */
private const val TAG = "CleanupWorker"

class CleanupWorker(ctx: Context, params: WorkerParameters) : CoroutineWorker(ctx, params) {

    override suspend fun doWork(): Result {
        /** Makes a notification when the work starts and slows down the work so that it's easier
         * to see each WorkRequest start, even on emulated devices
         */
        makeStatusNotification(
            applicationContext.resources.getString(R.string.cleaning_up_files),
            applicationContext
        )

        return withContext(Dispatchers.IO) {
            delay(DELAY_TIME_MILLIS)

            return@withContext try {
                val outputDirectory = File(applicationContext.filesDir, OUTPUT_PATH)
                if (outputDirectory.exists()) {
                    val entries = outputDirectory.listFiles()
                    if (entries != null) {
                        for (entry in entries) {
                            val name = entry.name
                            if (name.isNotEmpty() && name.endsWith(".png")) {
                                val deleted = entry.delete()
                                Log.i(TAG, "Deleted $name - $deleted")
                            }
                        }
                    }
                }
                Result.success()
            } catch (exception: Exception) {
                Log.e(
                    TAG,
                    applicationContext.resources.getString(R.string.error_cleaning_file),
                    exception
                )
                Result.failure()
            }
        }
    }
}