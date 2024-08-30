package com.example.currency_lib.data.remote

import com.example.currency_lib.data.model.ExchangeResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CurrencyRepository {

    private val api: ExchangeApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.exchangeratesapi.io/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ExchangeApi::class.java)
    }

    fun getLatestRates(accessKey: String, symbols: String): Call<ExchangeResponse> {
        return api.getLatestRates(accessKey, symbols)
    }

}