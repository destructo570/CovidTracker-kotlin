package com.destructo.corona_tracker.global.globalCountry

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.destructo.corona_tracker.model.GlobalCountryStatistics

@Suppress("UNCHECKED_CAST")
class CountryDetailViewModelFactory (
    private val selectedCountry: GlobalCountryStatistics,
    private val application: Application) : ViewModelProvider.Factory
    {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GlobalCountryDetailViewModel::class.java)) {
                return GlobalCountryDetailViewModel(
                    selectedCountry,
                    application
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }