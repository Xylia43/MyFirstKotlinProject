package com.example.first.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.first.MarsPhotosApplication
import com.example.first.data.MarsPhotosRepository
import com.example.first.model.Amphibians
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/27 22:32 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
sealed interface AmphibiansUiState {
    data class Success(val photos: List<Amphibians>) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}
class AmphibiansViewModel(private val amphibianRepository: MarsPhotosRepository): ViewModel() {
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set
    init {
        getAmphibiansList()
    }
    fun getAmphibiansList() {
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try {
                AmphibiansUiState.Success(amphibianRepository.getAmphibiansList() )
            } catch (e: IOException) {
                AmphibiansUiState.Error
            } catch (e: HttpException) {
                AmphibiansUiState.Error
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MarsPhotosApplication)
                val amphibianRepository = application.amphContainer.amphibiansRepository
                AmphibiansViewModel(amphibianRepository = amphibianRepository)
            }
        }
    }
}