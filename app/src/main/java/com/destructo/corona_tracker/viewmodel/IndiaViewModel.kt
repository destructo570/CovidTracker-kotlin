package com.destructo.corona_tracker.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.destructo.corona_tracker.model.GlobalCountryStatistics
import com.destructo.corona_tracker.model.IndiaStateStats
import com.destructo.corona_tracker.model.IndiaSummaryStats
import com.destructo.corona_tracker.repository.GlobalApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class IndiaViewModel:ViewModel() {

    private val  _indiaSummaryData = MutableLiveData<GlobalCountryStatistics>()
    val indiaSummaryData:LiveData<GlobalCountryStatistics>
    get() = _indiaSummaryData

    private val _indiaStateData = MutableLiveData<List<IndiaStateStats>>()
    val indiaStateData:LiveData<List<IndiaStateStats>>
    get() = _indiaStateData

    private val _navigateToStateDetails = MutableLiveData<IndiaStateStats>()
    val navigateToStateDetails:LiveData<IndiaStateStats>
    get() = _navigateToStateDetails


    private val indiaViewModelJob = Job()

    private val uiScope = CoroutineScope(indiaViewModelJob + Dispatchers.Main)

    init {
        getIndiaData()
    }

    private fun getIndiaData(){

        uiScope.launch {
            var getIndiaDataDeferred = GlobalApi.retrofitService.getIndiaDataAsync()
            var getIndiaSummaryDeferred = GlobalApi.retrofitService.getCountryDataAsync("india")

            try {
             val indiaCoronaStatistics = getIndiaDataDeferred.await()
             val indiaSummaryStatistics =  getIndiaSummaryDeferred.await()
                _indiaSummaryData.value = indiaSummaryStatistics
                _indiaStateData.value = indiaCoronaStatistics.states
            }catch (e:Exception){
                Log.e("IndiaViewModel","FAILED NETWORK ERROR\n" + e.message)
            }
        }
    }
    fun onNavigationToStateDetails(selectedState:IndiaStateStats){
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