package ru.zolotarev.tcurrency.domain

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import ru.zolotarev.tcurrency.data.CurrencyApi
import ru.zolotarev.tcurrency.data.RatesPayload


val retrofit = Retrofit.Builder()
    .baseUrl("https://api.tinkoff.ru")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    .create<CurrencyApi>()


class GetCurrentCurrencyUseCase(
    private val restApi: CurrencyApi
) {

    suspend operator fun invoke(): RatesPayload {
        return restApi.currencyRates().payload.rates.first { it.category == "CUTransfersPro" }
    }
}