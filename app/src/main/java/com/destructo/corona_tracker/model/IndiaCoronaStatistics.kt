package com.destructo.corona_tracker.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

data class IndiaCoronaStatistics (
    val data:IndiaData?,
    val lastRefreshed:String?,
    val lastOriginUpdate:String?
){}

data class IndiaData (
    @Json(name="regional")
    val stateStatistics:List<IndiaStateStatistics>?
){}

@Parcelize
data class IndiaStateStatistics (
    @Json(name="confirmedCasesIndian")
    val total_cases_indian:Int?,
    @Json(name="confirmedCasesForeign")
    val total_cases_foreign:Int?,
    @Json(name="discharged")
    val total_recovered:Int?,
    @Json(name="deaths")
    val total_deaths:Int?,
    @Json(name="loc")
    val state_name:String?,
    @Json(name="totalConfirmed")
    val total_cases:Int?,
    val total_active:Int?= total_deaths?.let { total_recovered?.plus(it)?.let { total_cases?.minus(it) } }
):Parcelable{}
