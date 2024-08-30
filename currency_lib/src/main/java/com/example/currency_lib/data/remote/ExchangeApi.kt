package com.example.currency_lib.data.remote

import com.example.currency_lib.data.model.ExchangeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeApi {
    @GET("latest")
    fun getLatestRates(
        @Query("access_key") accessKey: String,
        @Query("symbols") symbols: String
    ): Call<ExchangeResponse>

}