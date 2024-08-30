package com.example.currency_lib.data.model

data class Currency(
    val name: String,
    val currentRate: Double,
    val changeInLast24Hours: Double
)