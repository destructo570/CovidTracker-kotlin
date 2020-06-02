package com.destructo.corona_tracker.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

data class IndiaStatistics (
    @Json(name="updated")
    val last_updated:Long?,
    @Json(name="total")
    val summary:IndiaSummaryStats?,
    val states:List<IndiaStateStats>?
)

@Parcelize
data class IndiaStateStats (
    val state:String?,
    val cases:Int?,
    val recovered:Int?,
    val deaths:Int?,
    val active:Int?
):Parcelable

data class IndiaSummaryStats (
    val cases:Int?,
    val recovered:Int?,
    val deaths:Int?,
    val active:Int?)
