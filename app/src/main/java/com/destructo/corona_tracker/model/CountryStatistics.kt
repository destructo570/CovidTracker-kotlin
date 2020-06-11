package com.destructo.corona_tracker.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryStatistics (
    @Json(name="country")
    val country_name:String,
    @Json(name="cases")
    val total_infected:Int?,
    @Json(name="active")
    val total_active:Int?,
    @Json(name="recovered")
    val total_recovered:Int?,
    @Json(name="deaths")
    val total_deaths:Int?,
    @Json(name="critical")
    val critical_cases:Int?,
    @Json(name="todayCases")
    val cases_today:Int?,
    @Json(name="todayDeaths")
    val deaths_today:Int?,
    @Json(name="casesPerOneMillion")
    val cases_per_million:Double?,
    @Json(name="deathsPerOneMillion")
    val deaths_per_million:Double?,
    @Json(name="updated")
    val last_updated:Long?

):Parcelable
