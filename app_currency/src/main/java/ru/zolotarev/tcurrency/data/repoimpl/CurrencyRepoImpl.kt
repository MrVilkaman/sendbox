package ru.zolotarev.tcurrency.data.repoimpl

import ru.zolotarev.tcurrency.data.network.CurrencyApi
import ru.zolotarev.tcurrency.domain.models.CurrencyValue
import ru.zolotarev.tcurrency.domain.repo.CurrencyRepo


class CurrencyRepoImpl(
    private val restApi: CurrencyApi
) : CurrencyRepo {

    companion object {
        const val PRIMARY_CATEGORY = "CUTransfersPro"
    }

    override suspend fun getCurrencyRates(from: String, to: String): CurrencyValue? {
        // todo обработка ошибки

        return restApi.currencyRates(from, to).payload.rates.firstOrNull {
            it.category == PRIMARY_CATEGORY
        }?.let { CurrencyValue(it.buy, it.sell) }
    }
}