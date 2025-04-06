package com.example.currency_lib.domain.usecase

import com.example.currency_lib.domain.model.Currency
import com.example.currency_lib.domain.model.CurrencyChanges
import com.example.currency_lib.domain.repository.ExchangeRepository
import com.example.currency_lib.domain.util.CurrencyDate

class GetCurrencyRatesUseCase(
    private var currencyRepository: ExchangeRepository,
    private val dateUtil: CurrencyDate,
) {
    suspend fun getCurrencyRates(date: String): List<Currency> {
        return currencyRepository.getLatestRates(date)
    }

    suspend fun getCurrencyChanges(): List<CurrencyChanges> {
        return currencyRepository.getLatestRatesWithChanges(
            dateUtil.getYesterday(),
            dateUtil.getToday()
        )
    }
}