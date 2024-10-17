package com.example.first.ui
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.first.MarsPhotosApplication
import com.example.first.data.BusSchedule
import com.example.first.data.BusScheduleRepository
import kotlinx.coroutines.flow.Flow

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 14:44 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
class BusScheduleViewModel(private val busRepository: BusScheduleRepository): ViewModel() {

    // Get example bus schedule
//    fun getFullSchedule(): Flow<List<BusSchedule>> = flowOf(
//        listOf(
//            BusSchedule(
//                1,
//                "Example Street",
//                0
//            )
//        )
//    )
    // Get full bus schedule from Room DB
    fun getFullSchedule(): Flow<List<BusSchedule>> = busRepository.getAllItemsStream()

    // Get example bus schedule by stop
//    fun getScheduleFor(stopName: String): Flow<List<BusSchedule>> = flowOf(
//        listOf(
//            BusSchedule(
//                1,
//                "Example Street",
//                0
//            )
//        )
//    )
    // Get bus schedule based on the stop name from Room DB
    fun getScheduleFor(stopName: String): Flow<List<BusSchedule>> = busRepository.getItemStream(stopName)

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MarsPhotosApplication)
                val busRepository = application.busContainer.busRepository
                BusScheduleViewModel(busRepository)
            }
        }
    }
}