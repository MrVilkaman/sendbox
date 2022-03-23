package ru.zolotarev.tcurrency.domain.repo

import ru.zolotarev.tcurrency.domain.models.CurrencyValue


interface CurrencyRepo {

    companion object {
        const val USD = "USD"
        const val RUB = "RUB"
        const val EUR = "EUR"
    }

    suspend fun getCurrencyRates(from: String, to: String): CurrencyValue?
}