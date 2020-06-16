package com.destructo.corona_tracker.viewmodel.india

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.destructo.corona_tracker.model.IndiaStateStatistics


@Suppress("UNCHECKED_CAST")
class StateDetailViewModelFactory(
    private val stateData: IndiaStateStatistics,
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
