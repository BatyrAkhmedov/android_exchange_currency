package com.example.currency_lib.data.data_source

import com.example.currency_lib.domain.model.Currency
import com.example.currency_lib.domain.model.CurrencyChanges

interface ExchangeDataSource {
    suspend fun getExchangeCurrency(date:String) : List<Currency>

    suspend fun getExchangeCurrencyChanges(startDate:String, endDate:String) : List<CurrencyChanges>
}