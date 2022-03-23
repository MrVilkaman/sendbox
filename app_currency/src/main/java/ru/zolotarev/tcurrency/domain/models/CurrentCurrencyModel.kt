package ru.zolotarev.tcurrency.domain.models


data class CurrentCurrencyModel(
    val usdCoast: Double,
    val eurusd: Double,
    val usdBuy: Double,
    val spred: Double,
    val usdSold: Double,
)