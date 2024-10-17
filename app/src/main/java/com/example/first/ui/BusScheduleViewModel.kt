package com.example.first.ui
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.first.data.BusSchedule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 14:44 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
class BusScheduleViewModel: ViewModel() {

    // Get example bus schedule
    fun getFullSchedule(): Flow<List<BusSchedule>> = flowOf(
        listOf(
            BusSchedule(
                1,
                "Example Street",
                0
            )
        )
    )

    // Get example bus schedule by stop
    fun getScheduleFor(stopName: String): Flow<List<BusSchedule>> = flowOf(
        listOf(
            BusSchedule(
                1,
                "Example Street",
                0
            )
        )
    )

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                BusScheduleViewModel()
            }
        }
    }
}