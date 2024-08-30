package com.example.currency.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currency_lib.data.model.Currency
import com.example.currency_lib.domain.mappers.CurrencyMapper
import com.example.currency_lib.domain.usecase.GetCurrencyRatesUseCase

class CurrencyViewModel(private val getCurrencyRatesUseCase: GetCurrencyRatesUseCase, private val currencyMapper: CurrencyMapper) : ViewModel() {

    private val _currencies = MutableLiveData<List<Currency>>()
    val currencies: LiveData<List<Currency>> = _currencies

    fun fetchCurrencies(accessKey: String, symbols: String) {
        getCurrencyRatesUseCase.execute(accessKey, symbols) { response ->
            if (response != null && response.success) {
                _currencies.postValue(currencyMapper.map(response))
            } else {
                _currencies.postValue(emptyList())
            }
        }
    }
}