package ru.zolotarev.tcurrency.di

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import ru.zolotarev.tcurrency.data.CurrencyApi


object DIContainer {


    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.tinkoff.ru")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create<CurrencyApi>()
}


