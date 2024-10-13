package com.example.first.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.first.data.InvItemsRepository
import com.example.first.data.InventoryItem
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/**
 * @className: first
 * @desc: ViewModel to retrieve all items in the Room database.
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/12 21:26 Sat
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
class InvHomeViewModel(itemsRepository: InvItemsRepository): ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUiState: StateFlow<InvHomeUiState> =
        itemsRepository.getAllItemsStream().map { InvHomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = InvHomeUiState()
            )
}
/**
 * Ui State for HomeScreen
 */
data class InvHomeUiState(val itemList: List<InventoryItem> = listOf())