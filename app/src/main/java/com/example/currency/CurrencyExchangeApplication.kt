package com.example.currency

import android.app.Application
import android.content.Context
import com.example.currency_lib.DependencyProvider

class CurrencyExchangeApplication : Application() {
    lateinit var dependencyProvider: DependencyProvider
    override fun onCreate() {
        super.onCreate()
        dependencyProvider = DependencyProvider (this)
    }
}

val Context.dependency:DependencyProvider
    get() = if (this is CurrencyExchangeApplication) dependencyProvider
    else (applicationContext as CurrencyExchangeApplication).dependencyProvider