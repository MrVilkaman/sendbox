package ru.zolotarev.tcurrency.data.repoimpl

import ru.zolotarev.tcurrency.data.network.CurrencyApi
import ru.zolotarev.tcurrency.domain.models.CurrentCurrencyModel
import ru.zolotarev.tcurrency.domain.repo.CurrencyRepo


class CurrencyRepoImpl(
    private val restApi: CurrencyApi
) : CurrencyRepo {
    override suspend fun getCurrencyRates(): CurrentCurrencyModel {

        return restApi.currencyRates().payload.rates.first { it.category == "CUTransfersPro" }
            .let { first ->
                val spred = (first.sell - first.buy) / first.sell * 100
                val usdCoast = (first.sell + first.buy) / 2

                CurrentCurrencyModel(
                    usdCoast,
                    1.0,
                    first.sell,
                    spred,
                    first.buy
                )
            }
    }
}