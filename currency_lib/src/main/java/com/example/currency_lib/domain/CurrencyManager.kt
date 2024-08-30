package com.example.currency_lib.domain

import com.example.currency_lib.data.model.Currency
import com.example.currency_lib.domain.mappers.CurrencyMapper
import com.example.currency_lib.domain.usecase.GetCurrencyRatesUseCase

class CurrencyManager(private val getCurrencyRatesUseCase: GetCurrencyRatesUseCase, private val currencyMapper: CurrencyMapper) {

    fun fetchCurrencies(accessKey: String, symbols: String, callback: (List<Currency>?) -> Unit) {
        getCurrencyRatesUseCase.execute(accessKey, symbols) { response ->
            if (response != null && response.success) {
                val currencies = currencyMapper.map(response)
                callback(currencies)
            } else {
                callback(null)
            }
        }
    }
}