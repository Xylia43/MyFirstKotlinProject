package com.example.first.ui.screens

import androidx.lifecycle.ViewModel
import com.example.first.data.InventoryItem

/**
 * @className: first
 * @desc: ViewModel to retrieve all items in the Room database.
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/12 21:26 Sat
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
class InvHomeViewModel: ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}
/**
 * Ui State for HomeScreen
 */
data class InvHomeUiState(val itemList: List<InventoryItem> = listOf())