package ru.zolotarev.tcurrency.domain.usecase

import kotlinx.coroutines.*
import ru.zolotarev.tcurrency.domain.models.CurrentCurrencyModel
import ru.zolotarev.tcurrency.domain.repo.CurrencyRepo

class GetCurrentCurrencyUseCase(
    private val currencyRepo: CurrencyRepo
) {

    suspend operator fun invoke(): CurrentCurrencyModel = withContext(Dispatchers.IO) {
        val usdAsync = async { currencyRepo.getCurrencyRates(CurrencyRepo.USD, CurrencyRepo.RUB) }
        val eurAsync = async { currencyRepo.getCurrencyRates(CurrencyRepo.EUR, CurrencyRepo.RUB) }

        val usd = usdAsync.await() ?: throw IllegalStateException()
        val eur = eurAsync.await() ?: throw IllegalStateException()

        val eurusd = eur.coast / usd.coast
        CurrentCurrencyModel(
            usd.coast,
            eurusd,
            usd.sell,
            usd.spred,
            usd.buy
        )
    }
}