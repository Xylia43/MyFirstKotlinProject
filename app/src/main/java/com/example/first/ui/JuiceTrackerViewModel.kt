package com.example.first.ui

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/18 18:41 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.first.data.Juice
import com.example.first.data.JuiceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * ViewModel to retrieve, delete a juice entry from the [JuiceRepository]'s data source.
 */
class TrackerViewModel(private val juiceRepository: JuiceRepository): ViewModel()  {

    val juicesStream: Flow<List<Juice>> = juiceRepository.juicesStream

    fun deleteJuice(juice: Juice) = viewModelScope.launch {
        juiceRepository.deleteJuice(juice)
    }
}