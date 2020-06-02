package com.destructo.corona_tracker.country

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.destructo.corona_tracker.model.IndiaStateStats


@Suppress("UNCHECKED_CAST")
class StateDetailsViewModelFactory(
    private val stateData: IndiaStateStats,
    private val application: Application
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StateDetailViewModel::class.java)) {
            return StateDetailViewModel(
                stateData,
                application
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
