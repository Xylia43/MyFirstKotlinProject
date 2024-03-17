package com.example.first.data

import androidx.annotation.DrawableRes

data class DessertUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    val currentDessertPrice: Int = DessertDatasource.dessertList[currentDessertIndex].price,
    @DrawableRes val currentDessertImageId: Int= DessertDatasource.dessertList[currentDessertIndex].imageId

)
