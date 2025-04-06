package com.example.currency_lib.domain.model

data class CurrencyChanges(
    val name: String,
    val currentRate: Double,
    val changeInLast24Hours: Double
)
