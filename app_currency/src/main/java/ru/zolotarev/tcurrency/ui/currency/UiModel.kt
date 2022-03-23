package ru.zolotarev.tcurrency.ui.currency

import ru.zolotarev.tcurrency.domain.models.CurrentCurrencyModel

data class UiModel(
    val usdCoast: Double,
    val eurusd: Double,
    val usdBuy: Double,
    val spred: Double,
    val usdSold: Double,
)


fun CurrentCurrencyModel.toUiModel(): UiModel {
    return UiModel(
        usdCoast,
        eurusd,
        usdBuy,
        spred,
        usdSold,
    )
}