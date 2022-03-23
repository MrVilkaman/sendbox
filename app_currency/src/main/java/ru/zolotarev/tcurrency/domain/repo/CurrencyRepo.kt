package ru.zolotarev.tcurrency.domain.repo

import ru.zolotarev.tcurrency.domain.models.CurrentCurrencyModel


interface CurrencyRepo {

    suspend fun getCurrencyRates(): CurrentCurrencyModel
}