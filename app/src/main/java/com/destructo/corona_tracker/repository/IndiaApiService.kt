package com.destructo.corona_tracker.repository

import com.destructo.corona_tracker.model.IndiaCoronaStatistics
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.rootnet.in/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface IndiaApiService{

    @GET("covid19-in/stats/latest")
    fun getIndiaDataAsync(): Deferred<IndiaCoronaStatistics>
}

object IndiaApi {
    val retrofitService: IndiaApiService by lazy { retrofit.create(IndiaApiService::class.java) }
}