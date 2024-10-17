package com.example.first.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.first.DELAY_TIME_MILLIS
import com.example.first.KEY_BLUR_LEVEL
import com.example.first.KEY_IMAGE_URI
import com.example.first.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 22:36 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
private const val TAG = "BlurWorker"
class BlurWorker(ctx: Context , params: WorkerParameters) : CoroutineWorker(ctx, params) {
    override suspend fun doWork(): Result {
        // ADD THESE LINES
        val resourceUri = inputData.getString(KEY_IMAGE_URI)
        val blurLevel = inputData.getInt(KEY_BLUR_LEVEL, 1)
        return withContext(Dispatchers.IO) {
            makeStatusNotification(
                applicationContext.resources.getString(R.string.blurring_image) ,
                applicationContext
            )
            // This is an utility function added to emulate slower work.
            // This call is strictly for the codelab to provide a delay between notification messages.
            delay(DELAY_TIME_MILLIS)

            return@withContext try {
                // NEW code
                require(!resourceUri.isNullOrBlank()) {
                    val errorMessage =
                        applicationContext.resources.getString(R.string.invalid_input_uri)
                    Log.e(TAG, errorMessage)
                    errorMessage
                }
                val resolver = applicationContext.contentResolver
                val picture = BitmapFactory.decodeStream(
                    resolver.openInputStream(Uri.parse(resourceUri))
                )
//                val picture = BitmapFactory.decodeResource(
//                    applicationContext.resources ,
//                    R.drawable.cupcake
//                )
//                val output = blurBitmap(picture , 1)
                //val output = blurBitmap(picture, 1)
                val output = blurBitmap(picture, blurLevel)
                // Write bitmap to a temp file
                val outputUri = writeBitmapToFile(applicationContext , output)
                // The workDataOf() function creates a Data object from the passed in key and value pair.
                val outputData = workDataOf(KEY_IMAGE_URI to outputUri.toString())
                makeStatusNotification(
                    "Output is $outputUri" ,
                    applicationContext
                )
                Result.success(outputData)
            } catch (throwable: Throwable) {
                Log.e(
                    TAG ,
                    applicationContext.resources.getString(R.string.error_applying_blur) ,
                    throwable
                )
                Result.failure()
            }
        }
    }
}