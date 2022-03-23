package ru.zolotarev.tcurrency.data

import retrofit2.http.GET


interface CurrencyApi {

    @GET("v1/currency_rates?from=USD&to=RUB")
    suspend fun currencyRates(): CurrencyResponse
}

class CurrencyResponse(
    val trackingId: String,
    val resultCode: String,
    val payload: CurrencyPayload
)

class CurrencyPayload(
    val lastUpdate: LastUpdatePayload,
    val rates: List<RatesPayload>
)

class LastUpdatePayload(val milliseconds: Long)

class RatesPayload(
    val category: String,
    val fromCurrency: CurrencyMeta,
    val toCurrency: CurrencyMeta,
    val buy: Double,
    val sell: Double,
)

data class CurrencyMeta(val code: Int, val name: String)