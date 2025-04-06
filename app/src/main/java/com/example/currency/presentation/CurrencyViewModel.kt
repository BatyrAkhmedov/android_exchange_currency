package com.example.currency.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.currency.presentation.mapper.CurrencyUiMapper
import com.example.currency.presentation.model.CurrencyUiModel
import com.example.currency_lib.DependencyProvider
import com.example.currency_lib.domain.usecase.GetCurrencyRatesUseCase
import com.example.currency_lib.domain.util.CurrencyDate
import kotlinx.coroutines.launch

class CurrencyViewModel(
    private val getCurrencyRatesUseCase: GetCurrencyRatesUseCase,
    private val uiMapper: CurrencyUiMapper,
    private val currencyDate: CurrencyDate
) : ViewModel() {

    private val _currencies = MutableLiveData<List<CurrencyUiModel>>()
    val currencies: LiveData<List<CurrencyUiModel>> get() = _currencies

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun refreshCurrencies() {
        viewModelScope.launch {
            _isLoading.value = true
            val yesterdayList = getCurrencyRatesUseCase.getCurrencyRates(currencyDate.getYesterday())
            val todayList = getCurrencyRatesUseCase.getCurrencyRates(currencyDate.getToday())
            val mappedCurrencies = uiMapper.transformUsual(yesterdayList, todayList)
            _currencies.value = mappedCurrencies
            _isLoading.value = false
        }
    }

    companion object {
        fun createFactory(dependency: DependencyProvider) = defaultViewModel {
            CurrencyViewModel(
                getCurrencyRatesUseCase = dependency.provideGetCurrencyRatesUseCase(),
                uiMapper = CurrencyUiMapper(),
                currencyDate = CurrencyDate
            )
        }
    }
}
    inline fun <reified VM : ViewModel> defaultViewModel (
        noinline initialize: CreationExtras.() -> VM
    ): ViewModelProvider.Factory = viewModelFactory {
        initializer(initialize)
    }

