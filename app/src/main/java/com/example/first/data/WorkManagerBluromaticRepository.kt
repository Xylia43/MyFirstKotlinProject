package com.example.first.data
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import androidx.lifecycle.asFlow
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.first.IMAGE_MANIPULATION_WORK_NAME
import com.example.first.KEY_BLUR_LEVEL
import com.example.first.KEY_IMAGE_URI
import com.example.first.R
import com.example.first.TAG_OUTPUT
import com.example.first.workers.BlurWorker
import com.example.first.workers.CleanupWorker
import com.example.first.workers.SaveImageToFileWorker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 22:07 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
class WorkManagerBluromaticRepository(context: Context) : BluromaticRepository {
    // New code
    private val workManager = WorkManager.getInstance(context)
    private var imageUri: Uri = context.getImageUri() // <- Add this
    override val outputWorkInfo: Flow<WorkInfo> =
        workManager.getWorkInfosByTagLiveData(TAG_OUTPUT).asFlow().mapNotNull {
            if (it.isNotEmpty()) it.first() else null
        }

    /**
     * Create the WorkRequests to apply the blur and save the resulting image
     * @param blurLevel The amount to blur the image
     */
    override fun applyBlur(blurLevel: Int) {

        // Add WorkRequest to Cleanup temporary images
        var continuation = workManager.beginUniqueWork(//Blur-O-Matic now only blurs one image at a time.
            IMAGE_MANIPULATION_WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            OneTimeWorkRequest.from(CleanupWorker::class.java))

        // Create low battery constraint
        val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .build()

        // Create WorkRequest to blur the image
        val blurBuilder = OneTimeWorkRequestBuilder<BlurWorker>()
        // New code for input data object
        blurBuilder.setInputData(createInputDataForWorkRequest(blurLevel, imageUri))
        blurBuilder.setConstraints(constraints) // Add this code
//        // Start the work
//        workManager.enqueue(blurBuilder.build())
        // Add the blur work request to the chain
        continuation = continuation.then(blurBuilder.build())
        // Add WorkRequest to save the image to the filesystem
        val save = OneTimeWorkRequestBuilder<SaveImageToFileWorker>()
            .addTag(TAG_OUTPUT) // <- Add this
            .build()
        continuation = continuation.then(save)
        // Start the work
        continuation.enqueue()
    }

    /**
     * Cancel any ongoing WorkRequests
     * */
    override fun cancelWork() {
        workManager.cancelUniqueWork(IMAGE_MANIPULATION_WORK_NAME)
    }

    /**
     * Creates the input data bundle which includes the blur level to
     * update the amount of blur to be applied and the Uri to operate on
     * @return Data which contains the Image Uri as a String and blur level as an Integer
     */
    private fun createInputDataForWorkRequest(blurLevel: Int, imageUri: Uri): Data {
        val builder = Data.Builder()
        builder.putString(KEY_IMAGE_URI, imageUri.toString()).putInt(KEY_BLUR_LEVEL, blurLevel)
        return builder.build()
    }
    fun Context.getImageUri(): Uri {
        val resources = this.resources

        return Uri.Builder()
            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            .authority(resources.getResourcePackageName(R.drawable.hello))
            .appendPath(resources.getResourceTypeName(R.drawable.hello))
            .appendPath(resources.getResourceEntryName(R.drawable.hello))
            .build()
    }
}