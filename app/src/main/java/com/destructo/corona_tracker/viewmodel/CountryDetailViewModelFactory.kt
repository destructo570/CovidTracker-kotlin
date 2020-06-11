package com.destructo.corona_tracker.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.destructo.corona_tracker.model.CountryStatistics

@Suppress("UNCHECKED_CAST")
class CountryDetailViewModelFactory (
    private val selectedCountry: CountryStatistics,
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