package com.example.first.ui
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.first.MarsPhotosApplication
import com.example.first.data.Reminder
import com.example.first.data.WaterRepository
/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/18 17:04 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */

class WaterViewModel(private val waterRepository: WaterRepository) : ViewModel() {

    internal val plants = waterRepository.plants

    fun scheduleReminder(reminder: Reminder) {
        waterRepository.scheduleReminder(reminder.duration, reminder.unit, reminder.plantName)
    }

    /**
     * Factory for [WaterViewModel] that takes [WaterRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val waterRepository =
                    (this[APPLICATION_KEY] as MarsPhotosApplication).waterMeContainer.waterRepository
                WaterViewModel(
                    waterRepository = waterRepository
                )
            }
        }
    }
}