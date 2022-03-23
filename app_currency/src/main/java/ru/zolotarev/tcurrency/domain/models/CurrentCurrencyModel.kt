package ru.zolotarev.tcurrency.domain.models


data class CurrentCurrencyModel(
    val usdCoast: Double,
    val eurusd: Double,
    val usdBuy: Double,
    val spred: Double,
    val usdSold: Double,
)

data class CurrencyValue(
    val buy: Double,
    val sell: Double,
) {
    val spred: Double = (sell - buy) / sell * 100

    val coast = (sell + buy) / 2
}