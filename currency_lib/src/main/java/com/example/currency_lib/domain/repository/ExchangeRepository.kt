package com.example.currency_lib.domain.repository

import com.example.currency_lib.domain.model.Currency
import com.example.currency_lib.domain.model.CurrencyChanges
import retrofit2.Call

interface ExchangeRepository {
    suspend fun getLatestRates(date:String): List<Currency>

    suspend fun getLatestRatesWithChanges(startDate: String, endDate: String): List<CurrencyChanges>
}