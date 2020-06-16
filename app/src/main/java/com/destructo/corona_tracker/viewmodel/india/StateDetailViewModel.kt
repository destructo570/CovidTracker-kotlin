package com.destructo.corona_tracker.viewmodel.india

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.destructo.corona_tracker.model.IndiaStateStatistics

class StateDetailViewModel (state: IndiaStateStatistics, application: Application) : AndroidViewModel(application) {

    private val _stateSummary = MutableLiveData<IndiaStateStatistics>()
    val stateSummary: LiveData<IndiaStateStatistics>
    get() = _stateSummary

    init {
        _stateSummary.value = state
    }

}