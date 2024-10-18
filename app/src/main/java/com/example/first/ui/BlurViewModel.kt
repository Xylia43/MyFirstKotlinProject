package com.example.first.ui
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.work.WorkInfo
import com.example.first.KEY_IMAGE_URI
import com.example.first.MarsPhotosApplication
import com.example.first.data.BlurAmountData
import com.example.first.data.BluromaticRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/10/17 22:08 Thu
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
/**
 * [BlurViewModel] starts and stops the WorkManger and applies blur to the image. Also updates the
 * visibility states of the buttons depending on the states of the WorkManger.
 */
class BlurViewModel(private val bluromaticRepository: BluromaticRepository) : ViewModel() {

    internal val blurAmount = BlurAmountData.blurAmount

//    val blurUiState: StateFlow<BlurUiState> = MutableStateFlow(BlurUiState.Default)
    val blurUiState: StateFlow<BlurUiState> =
        bluromaticRepository.outputWorkInfo
            .map { info ->
                val outputImageUri = info.outputData.getString(KEY_IMAGE_URI)
                when {
                    info.state.isFinished && !outputImageUri.isNullOrEmpty() -> {
                        BlurUiState.Complete(outputUri = outputImageUri)
                    }
                    info.state == WorkInfo.State.CANCELLED -> {
                        BlurUiState.Default
                    }
                    else -> BlurUiState.Loading
                }
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = BlurUiState.Default
            )

    /**
     * Call the method from repository to create the WorkRequest to apply the blur
     * and save the resulting image
     * @param blurLevel The amount to blur the image
     */
    fun applyBlur(blurLevel: Int) {
        bluromaticRepository.applyBlur(blurLevel)
    }

    /**
     * Factory for [BlurViewModel] that takes [BluromaticRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val bluromaticRepository =
                    (this[APPLICATION_KEY] as MarsPhotosApplication).blurContainer.bluromaticRepository
                BlurViewModel(
                    bluromaticRepository = bluromaticRepository
                )
            }
        }
    }
    /**
     * Call method from repository to cancel any ongoing WorkRequest
     * */
    fun cancelWork() {
        bluromaticRepository.cancelWork()
    }
}

sealed interface BlurUiState {
    object Default : BlurUiState
    object Loading : BlurUiState
    data class Complete(val outputUri: String) : BlurUiState
}