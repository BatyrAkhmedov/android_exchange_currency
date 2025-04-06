package com.example.currency_lib.data.retrofit

import com.example.currency_lib.data.model.CurrencyChangesDto
import com.example.currency_lib.data.model.CurrencyExchangeDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private const val BASE_URL = "https://api.exchangeratesapi.io/v1/"
private const val ACCESS_KEY = "09692c0129301bf0639076c92a9f7b2c"
private const val BASE_CURRENCY = "EUR"
private val okHttpClient = OkHttpClient.Builder().addInterceptor(
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()

interface ExchangeApiService {
    @GET("{date}")
    suspend fun getRatesFromDate(
        @Path ("date") date: String,
        @Query("access_key") accessKey: String = ACCESS_KEY,
        @Query("base") base: String = BASE_CURRENCY,
        @Query("symbols") symbols: String
    ): CurrencyExchangeDto

    @GET("timeseries")
    suspend fun getLast24HoursChangesRates(
        @Query("access_key") accessKey: String = ACCESS_KEY,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("base") base: String = BASE_CURRENCY,
        @Query("symbols") symbols: String,
    ): CurrencyChangesDto
}

object ExchangeApi {
    val retrofitService: ExchangeApiService by lazy {
        retrofit.create(ExchangeApiService::class.java)
    }
}
