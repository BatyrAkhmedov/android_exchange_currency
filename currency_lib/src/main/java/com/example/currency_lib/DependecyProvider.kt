package com.example.currency_lib

import android.content.Context
import com.example.currency_lib.data.data_source.ExchangeDataSourceImpl
import com.example.currency_lib.data.mapper.CurrencyExchangeDtoMapper
import com.example.currency_lib.data.repository.ExchangeRepositoryImpl
import com.example.currency_lib.data.retrofit.ExchangeApi
import com.example.currency_lib.data.retrofit.ExchangeApiService
import com.example.currency_lib.domain.repository.ExchangeRepository
import com.example.currency_lib.domain.usecase.GetCurrencyRatesUseCase
import com.example.currency_lib.domain.util.CurrencyDate

class DependencyProvider (context: Context) {

    fun provideGetCurrencyRatesUseCase(): GetCurrencyRatesUseCase = GetCurrencyRatesUseCase(
        currencyRepository = provideCurrencyRepository(),
        dateUtil = provideDateUtil()
    )

    fun provideCurrencyRepository(): ExchangeRepository = ExchangeRepositoryImpl(
        dataSource = provideExchangeDataSource()
    )

    fun provideExchangeDataSource(): ExchangeDataSourceImpl = ExchangeDataSourceImpl(
        service = provideApiService(),
        mapper = provideCurrencyExchangeDtoMapper()
    )

    fun provideCurrencyExchangeDtoMapper(): CurrencyExchangeDtoMapper = CurrencyExchangeDtoMapper()

    fun provideApiService(): ExchangeApiService = ExchangeApi.retrofitService

    fun provideDateUtil(): CurrencyDate = CurrencyDate
}