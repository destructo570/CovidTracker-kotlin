package com.destructo.corona_tracker.global.globalDetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.destructo.corona_tracker.model.GlobalCoronaStatistics

@Suppress("UNCHECKED_CAST")
class GlobalDetailsViewModelFactory (
    private val globalSummary: GlobalCoronaStatistics,
    private val application: Application
    ) : ViewModelProvider.Factory
    {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GlobalDetailsViewModel::class.java)) {
                return GlobalDetailsViewModel(
                    globalSummary,
                    application
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
