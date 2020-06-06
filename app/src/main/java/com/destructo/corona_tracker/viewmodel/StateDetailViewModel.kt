package com.destructo.corona_tracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.destructo.corona_tracker.model.IndiaStateStats

class StateDetailViewModel (state: IndiaStateStats, application: Application) : AndroidViewModel(application) {

    private val _stateSummary = MutableLiveData<IndiaStateStats>()
    val stateSummary: LiveData<IndiaStateStats>
    get() = _stateSummary

    init {
        _stateSummary.value = state
    }

}