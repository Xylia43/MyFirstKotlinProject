package com.example.first.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.first.data.Juice
import com.example.first.data.JuiceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/18 18:40 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */

/**
 * ViewModel to retrieve, add, edit or delete a juice entry
 * from the [JuiceRepository]'s data source.
 */
class JuiceEntryViewModel(private val juiceRepository: JuiceRepository) : ViewModel() {

    fun getJuiceStream(id: Long): Flow<Juice?> = juiceRepository.getJuiceStream(id)

    fun saveJuice(
        id: Long,
        name: String,
        description: String,
        color: String,
        rating: Int
    ) {
        val juice = Juice(id, name, description, color, rating)
        viewModelScope.launch {
            if (id > 0) {
                juiceRepository.updateJuice(juice)
            } else {
                juiceRepository.addJuice(juice)
            }
        }
    }
}