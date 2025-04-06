package com.example.currency_lib.data.mapper

import com.example.currency_lib.data.model.CurrencyChangesDto
import com.example.currency_lib.data.model.CurrencyExchangeDto
import com.example.currency_lib.domain.model.Currency
import com.example.currency_lib.domain.model.CurrencyChanges

class CurrencyExchangeDtoMapper {
    fun transformAll(input: CurrencyExchangeDto): List<Currency> {
        val list = input.rates.map { (key, value) ->
            Currency(
                name = key,
                currentRate = value
            )
        }

        return list
    }

    fun transformAllCurrencyChanges(input:CurrencyChangesDto) : List<CurrencyChanges> {
        val listOfMap = input.rates.values
        val dataFromStartDate = listOfMap.first()
        val dataFromEndDate = listOfMap.last()
        val resultList = dataFromEndDate.map { (key, value) ->
            CurrencyChanges(
                name = key,
                currentRate = value,
                changeInLast24Hours = value - dataFromStartDate[key]!!
            )
        }
        return resultList
    }
}