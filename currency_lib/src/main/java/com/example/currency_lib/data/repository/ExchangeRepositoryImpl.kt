package com.example.currency_lib.data.repository

import com.example.currency_lib.data.data_source.ExchangeDataSource
import com.example.currency_lib.data.model.CurrencyExchangeDto
import com.example.currency_lib.domain.model.Currency
import com.example.currency_lib.domain.model.CurrencyChanges
import com.example.currency_lib.domain.repository.ExchangeRepository
import com.example.currency_lib.domain.util.CurrencyDate
import retrofit2.Call

class ExchangeRepositoryImpl(
    private val dataSource: ExchangeDataSource,
) : ExchangeRepository {
    override suspend fun getLatestRates(date: String): List<Currency> =
        dataSource.getExchangeCurrency(date)


    override suspend fun getLatestRatesWithChanges(
        startDate: String,
        endDate: String,
    ): List<CurrencyChanges> = dataSource.getExchangeCurrencyChanges(startDate, endDate)

}