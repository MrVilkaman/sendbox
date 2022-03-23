package ru.zolotarev.tcurrency.domain.usecase

import ru.zolotarev.tcurrency.domain.models.CurrentCurrencyModel
import ru.zolotarev.tcurrency.domain.repo.CurrencyRepo


class GetCurrentCurrencyUseCase(
    private val currencyRepo: CurrencyRepo
) {

    suspend operator fun invoke(): CurrentCurrencyModel {
        return currencyRepo.getCurrencyRates()
    }
}