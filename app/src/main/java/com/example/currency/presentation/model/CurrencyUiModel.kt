package com.example.currency.presentation.model

data class CurrencyUiModel (
    val name: String,
    val rate: String,
    val changeInLast24Hours: Double
)