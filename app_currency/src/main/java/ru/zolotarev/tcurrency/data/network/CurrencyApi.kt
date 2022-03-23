package ru.zolotarev.tcurrency.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.zolotarev.tcurrency.data.models.CurrencyResponse


interface CurrencyApi {

    @GET("v1/currency_rates")
    suspend fun currencyRates(@Query("from") from: String, @Query("to") to: String): CurrencyResponse
}