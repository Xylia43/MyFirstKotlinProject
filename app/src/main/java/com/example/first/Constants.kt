package com.example.first

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 22:15 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
// Notification Channel constants

// Name of Notification Channel for verbose notifications of background work
val VERBOSE_NOTIFICATION_CHANNEL_NAME: CharSequence =
    "Verbose WorkManager Notifications"
const val VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION =
    "Shows notifications whenever work starts"
val NOTIFICATION_TITLE: CharSequence = "WorkRequest Starting"
const val CHANNEL_ID = "VERBOSE_NOTIFICATION"
const val NOTIFICATION_ID = 1

// The name of the image manipulation work
const val IMAGE_MANIPULATION_WORK_NAME = "image_manipulation_work"

// Other keys
const val OUTPUT_PATH = "blur_filter_outputs"
const val KEY_IMAGE_URI = "KEY_IMAGE_URI"
const val TAG_OUTPUT = "OUTPUT"
const val KEY_BLUR_LEVEL = "KEY_BLUR_LEVEL"

const val DELAY_TIME_MILLIS: Long = 3000
// Notification Channel constants

// water me app
// Title of Notification for verbose notifications of background work
//val NOTIFICATION_TITLE: CharSequence = "Water me!"


// Request code for pending intent
const val REQUEST_CODE = 0

// Reminder schedule
const val FIVE_SECONDS: Long = 5
const val ONE_DAY: Long = 1
const val SEVEN_DAYS: Long = 7
const val THIRTY_DAYS: Long = 30