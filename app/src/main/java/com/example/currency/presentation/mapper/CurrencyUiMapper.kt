package com.example.currency.presentation.mapper

import com.example.currency.presentation.model.CurrencyUiModel
import com.example.currency_lib.domain.model.Currency
import com.example.currency_lib.domain.model.CurrencyChanges

class CurrencyUiMapper() {
    fun transform(currencies: List<CurrencyChanges>): List<CurrencyUiModel> {
        return currencies.map { currency ->
            CurrencyUiModel(
                name = currency.name,
                rate = "${currency.currentRate} ₸",
                changeInLast24Hours = currency.changeInLast24Hours
            )
        }
    }

    fun transformUsual(startDate: List<Currency>, endDate: List<Currency>): List<CurrencyUiModel> {
        return endDate.map { currency ->
            val previousRate = startDate.find { it.name == currency.name }?.currentRate
            val change = previousRate?.let { currency.currentRate - it } ?: 0.0
            CurrencyUiModel(
                name = currency.name,
                rate = "${currency.currentRate}",
                changeInLast24Hours = change
            )
        }
    }
}
