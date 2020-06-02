package com.destructo.corona_tracker.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GlobalCoronaStatistics (

    @Json(name="cases")
    val infected:Int?,
    @Json(name="recovered")
    val recovered:Int?,
    @Json(name="active")
    val active:Int?,
    @Json(name="deaths")
    val deaths:Int?,
    @Json(name="critical")
    val critical:Int?,
    @Json(name="todayCases")
    val cases_today:Int?,
    @Json(name="todayDeaths")
    val deaths_today:Int?,
    @Json(name="casesPerOneMillion")
    val cases_per_million:Double?,
    @Json(name="deathsPerOneMillion")
    val deaths_per_million:Double?,
    @Json(name="affectedCountries")
    val affected_countries:Int?,
    @Json(name="updated")
    val last_update:Long?

): Parcelable