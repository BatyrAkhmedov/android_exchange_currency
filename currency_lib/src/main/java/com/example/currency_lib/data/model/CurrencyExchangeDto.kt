package com.example.currency_lib.data.model

data class CurrencyExchangeDto(
    val success: Boolean,
    val timestamp: Long,
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)