package com.example.currency_lib.domain.util

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Locale

object CurrencyDate {
        fun getToday(): String {
            val calendar = Calendar.getInstance()
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            return dateFormat.format(calendar.time)
        }

        fun getYesterday(): String {
            val calendar = Calendar.getInstance()
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            calendar.add(Calendar.DAY_OF_YEAR, -1)
            return dateFormat.format(calendar.time)
        }
}