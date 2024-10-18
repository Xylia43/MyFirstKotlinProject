package com.example.first.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.first.MarsPhotosApplication
import com.example.first.ui.item.InvItemDetailsViewModel
import com.example.first.ui.item.InvItemEditViewModel
import com.example.first.ui.item.InvItemEntryViewModel
import com.example.first.ui.screens.InvHomeViewModel

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/12 21:50 Sat
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object InvAppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            InvItemEditViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().invContainer.itemsRepository
            )
        }
        // Initializer for ItemEntryViewModel
        initializer {
            InvItemEntryViewModel(inventoryApplication().invContainer.itemsRepository)
        }

        // Initializer for ItemDetailsViewModel
        initializer {
            InvItemDetailsViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().invContainer.itemsRepository
            )
        }

        // Initializer for HomeViewModel
        initializer {
            InvHomeViewModel(inventoryApplication().invContainer.itemsRepository)
        }
        /**
         * Juice view app
         */
        // Initializer for ItemEntryViewModel
        initializer {
            JuiceEntryViewModel(juiceTrackerApplication().juiceContainer.trackerRepository)
        }
        // Initializer for TrackerViewModel
        initializer {
            TrackerViewModel(juiceTrackerApplication().juiceContainer.trackerRepository)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.inventoryApplication(): MarsPhotosApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as MarsPhotosApplication)
/**
 * Extension function to query for [Application] object and returns an instance of
 * [JuiceTrackerApplication].
 */
fun CreationExtras.juiceTrackerApplication(): MarsPhotosApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as MarsPhotosApplication)