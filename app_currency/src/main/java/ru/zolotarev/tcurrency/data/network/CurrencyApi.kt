package ru.zolotarev.tcurrency.data.network

import retrofit2.http.GET
import ru.zolotarev.tcurrency.data.models.CurrencyResponse


interface CurrencyApi {

    @GET("v1/currency_rates?from=USD&to=RUB")
    suspend fun currencyRates(): CurrencyResponse
}