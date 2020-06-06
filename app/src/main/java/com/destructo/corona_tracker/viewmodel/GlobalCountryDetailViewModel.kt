package com.destructo.corona_tracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.destructo.corona_tracker.model.GlobalCountryStatistics

class GlobalCountryDetailViewModel(country: GlobalCountryStatistics, application: Application) : AndroidViewModel(application) {


    private val _selectedCountry = MutableLiveData<GlobalCountryStatistics>()
    val SelectedCountry: LiveData<GlobalCountryStatistics>
    get() = _selectedCountry

    init {
        _selectedCountry.value = country
    }
}