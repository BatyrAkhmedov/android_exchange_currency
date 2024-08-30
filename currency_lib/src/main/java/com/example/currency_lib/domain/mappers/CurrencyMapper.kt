package com.example.currency_lib.domain.mappers

import com.example.currency_lib.data.model.Currency
import com.example.currency_lib.data.model.ExchangeResponse

class CurrencyMapper {

    fun map(response: ExchangeResponse): List<Currency> {
        val currencyList = mutableListOf<Currency>()

        for ((key, value) in response.rates) {
            currencyList.add(Currency(name = key, currentRate = value, changeInLast24Hours = calculateChange(value)))
        }

        return currencyList
    }

    private fun calculateChange(currentRate: Double): Double {

        return Math.random() * 2 - 1
    }
}