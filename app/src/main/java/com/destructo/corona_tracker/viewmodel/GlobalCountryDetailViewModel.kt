package com.destructo.corona_tracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.destructo.corona_tracker.model.CountryStatistics

class GlobalCountryDetailViewModel(country: CountryStatistics, application: Application) : AndroidViewModel(application) {


    private val _selectedCountry = MutableLiveData<CountryStatistics>()
    val SelectedCountry: LiveData<CountryStatistics>
    get() = _selectedCountry

    init {
        _selectedCountry.value = country
    }
}