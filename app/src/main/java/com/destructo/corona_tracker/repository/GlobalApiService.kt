package com.destructo.corona_tracker.repository

import com.destructo.corona_tracker.model.GlobalCoronaStatistics
import com.destructo.corona_tracker.model.CountryStatistics
import com.destructo.corona_tracker.model.IndiaStatistics
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://disease.sh/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface GlobalApiService {

    @GET("all")
    fun getGlobalDataAsync(): Deferred<GlobalCoronaStatistics>


    @GET("countries?sort=cases")
    fun getGlobalCountryDataAsync(): Deferred<List<CountryStatistics>>

    @GET("gov/india")
    fun getIndiaDataAsync(): Deferred<IndiaStatistics>


    @GET("countries/{country}")
    fun getCountryDataAsync(@Path("country") country:String): Deferred<CountryStatistics>
}

object GlobalApi {
    val retrofitService: GlobalApiService by lazy { retrofit.create(GlobalApiService::class.java) }
}

