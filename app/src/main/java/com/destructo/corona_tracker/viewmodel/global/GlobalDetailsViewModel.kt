package com.destructo.corona_tracker.viewmodel.global

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.destructo.corona_tracker.model.GlobalCoronaStatistics

class GlobalDetailsViewModel(val globalSummary:GlobalCoronaStatistics, application: Application) :AndroidViewModel(application) {

    private val _GlobalSummaryData = MutableLiveData<GlobalCoronaStatistics>()
    val globalSummaryData: LiveData<GlobalCoronaStatistics>
    get() = _GlobalSummaryData

    init {
        _GlobalSummaryData.value = globalSummary
    }



}