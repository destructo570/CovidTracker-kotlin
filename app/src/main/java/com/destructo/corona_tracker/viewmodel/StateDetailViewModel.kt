package com.destructo.corona_tracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.destructo.corona_tracker.model.IndiaStateStatistics
import com.destructo.corona_tracker.model.IndiaStateStats

class StateDetailViewModel (state: IndiaStateStatistics, application: Application) : AndroidViewModel(application) {

    private val _stateSummary = MutableLiveData<IndiaStateStatistics>()
    val stateSummary: LiveData<IndiaStateStatistics>
    get() = _stateSummary

    init {
        _stateSummary.value = state
    }

}