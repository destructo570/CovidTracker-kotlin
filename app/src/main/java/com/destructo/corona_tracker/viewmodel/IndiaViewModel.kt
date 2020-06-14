package com.destructo.corona_tracker.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.destructo.corona_tracker.model.CountryStatistics
import com.destructo.corona_tracker.model.IndiaStateStatistics
import com.destructo.corona_tracker.repository.GlobalApi
import com.destructo.corona_tracker.repository.IndiaApi
import com.destructo.corona_tracker.repository.IndiaApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class IndiaViewModel:ViewModel() {

    private val  _indiaSummaryData = MutableLiveData<CountryStatistics>()
    val indiaSummaryData:LiveData<CountryStatistics>
    get() = _indiaSummaryData

    private val _indiaStateData = MutableLiveData<List<IndiaStateStatistics>>()
    val indiaStateData:LiveData<List<IndiaStateStatistics>>
    get() = _indiaStateData

    private val _navigateToStateDetails = MutableLiveData<IndiaStateStatistics>()
    val navigateToStateDetails:LiveData<IndiaStateStatistics>
    get() = _navigateToStateDetails


    private val indiaViewModelJob = Job()

    private val uiScope = CoroutineScope(indiaViewModelJob + Dispatchers.Main)

    init {
        getIndiaData()
    }

    private fun getIndiaData(){

        uiScope.launch {
            var getIndiaDataDeferred = IndiaApi.retrofitService.getIndiaDataAsync()
            var getIndiaSummaryDeferred = GlobalApi.retrofitService.getCountryDataAsync("india")

            try {
             val indiaCoronaStatistics = getIndiaDataDeferred.await()
             val indiaSummaryStatistics =  getIndiaSummaryDeferred.await()
                _indiaSummaryData.value = indiaSummaryStatistics
                _indiaStateData.value = indiaCoronaStatistics.data?.stateStatistics
            }catch (e:Exception){
                Log.e("IndiaViewModel","FAILED NETWORK ERROR\n" + e.message)
            }
        }
    }
    fun onNavigationToStateDetails(selectedState:IndiaStateStatistics){
        _navigateToStateDetails.value = selectedState
    }

    fun doneNavigationToStateDetails(){
        _navigateToStateDetails.value = null
    }

    override fun onCleared() {
        super.onCleared()
        indiaViewModelJob.cancel()
    }
}