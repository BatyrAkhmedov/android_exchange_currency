package com.example.currency_lib.domain.usecase

import com.example.currency_lib.data.model.ExchangeResponse
import com.example.currency_lib.data.remote.CurrencyRepository
import retrofit2.Call

class GetCurrencyRatesUseCase(private val currencyRepository: CurrencyRepository) {

    fun execute(accessKey: String, symbols: String, callback: (ExchangeResponse?) -> Unit) {
        currencyRepository.getLatestRates(accessKey, symbols).enqueue(object : retrofit2.Callback<ExchangeResponse> {
            override fun onResponse(call: Call<ExchangeResponse>, response: retrofit2.Response<ExchangeResponse>) {
                callback(response.body())
            }

            override fun onFailure(call: Call<ExchangeResponse>, t: Throwable) {
                callback(null)
            }
        })
    }
}