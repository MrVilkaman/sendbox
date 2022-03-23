package ru.zolotarev.tcurrency.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import ru.zolotarev.tcurrency.data.network.CurrencyApi


object DIContainer {

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()


    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.tinkoff.ru")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
        .create<CurrencyApi>()
}


