package com.example.first

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.first.data.AmphAppContainer
import com.example.first.data.AmphibiansAppContainer
import com.example.first.data.AppDataContainer
import com.example.first.data.BusCcheduleContainer
import com.example.first.data.DefaultAppContainer
import com.example.first.data.InvAppContainer
import com.example.first.data.MarsAppContainer
import com.example.first.data.UserPreferencesRepository

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/27 14:05 Fri
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
class MarsPhotosApplication : Application()  {
    lateinit var marsContainer: MarsAppContainer
    lateinit var amphContainer: AmphibiansAppContainer
    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var invContainer: InvAppContainer
    lateinit var busContainer: BusCcheduleContainer

    /**
     * datastore app
     */
    lateinit var userPreferencesRepository: UserPreferencesRepository

    override fun onCreate() {
        super.onCreate()
        marsContainer = DefaultAppContainer()
        amphContainer = AmphAppContainer()
        invContainer = AppDataContainer(this)
        busContainer = BusCcheduleContainer(this)
        userPreferencesRepository = UserPreferencesRepository(dataStore)
    }
}
private const val LAYOUT_PREFERENCE_NAME = "layout_preferences"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = LAYOUT_PREFERENCE_NAME
)