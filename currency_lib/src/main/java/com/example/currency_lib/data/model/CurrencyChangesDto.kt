package com.example.currency_lib.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CurrencyChangesDto(
    @SerializedName ("base") val currentCurrency: String,
    @SerializedName ("start_date") val startDate: String,
    @SerializedName ("end_date") val endDate: String,
    val rates: Map<String, Map<String, Double>>,
)
