package com.example.currency_lib.data.data_source

import com.example.currency_lib.data.mapper.CurrencyExchangeDtoMapper
import com.example.currency_lib.data.retrofit.ExchangeApiService
import com.example.currency_lib.domain.model.Currency
import com.example.currency_lib.domain.model.CurrencyChanges

class ExchangeDataSourceImpl(
    private val service: ExchangeApiService,
    private val mapper: CurrencyExchangeDtoMapper,
) : ExchangeDataSource {
    override suspend fun getExchangeCurrency(date: String): List<Currency> {
        val currencies = service.getRatesFromDate(symbols = SYMBOLS, date = date)
        return mapper.transformAll(currencies)
    }

    override suspend fun getExchangeCurrencyChanges(startDate:String, endDate:String): List<CurrencyChanges> {
        val currencies = service.getLast24HoursChangesRates(
            symbols = SYMBOLS,
            startDate = startDate,
            endDate = endDate
        )
        return mapper.transformAllCurrencyChanges(currencies)
    }

    companion object {
        private const val SYMBOLS = "USD,KZT,AUD,JPY,GBP,EUR,CAD,CHF,CNY,NZD,SEK,NOK,SGD,HKD,TRY"
    }
}