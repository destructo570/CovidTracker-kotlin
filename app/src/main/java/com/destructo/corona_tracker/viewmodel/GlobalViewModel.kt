package com.destructo.corona_tracker.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.destructo.corona_tracker.model.GlobalCoronaStatistics
import com.destructo.corona_tracker.model.GlobalCountryStatistics
import com.destructo.corona_tracker.repository.GlobalApi
import kotlinx.coroutines.*
import java.lang.Exception

class GlobalViewModel : ViewModel() {

    private var _globalStats = MutableLiveData<GlobalCoronaStatistics>()
    val globalStats: LiveData<GlobalCoronaStatistics>
        get() = _globalStats

    private var _globalCountryStats = MutableLiveData<List<GlobalCountryStatistics>>()
    val globalCountryStats:LiveData<List<GlobalCountryStatistics>>
    get() = _globalCountryStats

    private val _navigateToCountryDetail = MutableLiveData<GlobalCountryStatistics>()
    val navigateToCountryDetail: LiveData<GlobalCountryStatistics>
    get() = _navigateToCountryDetail

    private var globalViewModelJob = Job()

    private val uiScope = CoroutineScope(globalViewModelJob + Dispatchers.Main)


    init {
        getGlobalStatistics()
        getCountryStatsList()
    }

    private fun getGlobalStatistics() {
        uiScope.launch {
            var getGlobalDataDef = GlobalApi.retrofitService.getGlobalDataAsync()
            try {

                val globalData = getGlobalDataDef.await()
                _globalStats.value = globalData
            } catch (e: Exception) {

                Log.e("GlobalViewModel", "FAILED NETWORK\n" + e.message)
            }
        }

    }

    private fun getCountryStatsList(){
        uiScope.launch {

            var getCountryDeferred = GlobalApi.retrofitService.getGlobalCountryDataAsync()
            try {
                val globalCountry = getCountryDeferred.await()
                _globalCountryStats.value = globalCountry
            }catch (e:Exception){
                Log.e("GlobalviewModel","Error"+e.message)
            }
        }
    }

    fun navigationToCountryDetail(selectedCountry:GlobalCountryStatistics){
        _navigateToCountryDetail.value = selectedCountry
    }
    fun doneNavigationToCountryDetail(){
        _navigateToCountryDetail.value = null
    }

    override fun onCleared() {
        super.onCleared()
        globalViewModelJob.cancel()
    }


}