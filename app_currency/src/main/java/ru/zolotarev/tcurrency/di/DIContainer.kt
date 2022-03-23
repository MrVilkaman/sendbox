package ru.zolotarev.tcurrency.di

import android.app.Application
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import ru.zolotarev.tcurrency.app.App
import ru.zolotarev.tcurrency.data.network.CurrencyApi
import ru.zolotarev.tcurrency.data.repoimpl.CurrencyRepoImpl
import ru.zolotarev.tcurrency.domain.repo.CurrencyRepo
import ru.zolotarev.tcurrency.domain.usecase.GetCurrentCurrencyUseCase
import ru.zolotarev.tcurrency.ui.currency.CurrencyViewModel


fun Application.setupKoin() {
    GlobalContext.startKoin {
        androidLogger(Level.ERROR)
        androidContext(this@setupKoin)
        modules(appDiModule, domainDiModule, dataDiModule)
    }
}


val dataDiModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .build()
    }

    single<CurrencyApi> {
        Retrofit.Builder()
            .baseUrl("https://api.tinkoff.ru")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
            .create<CurrencyApi>()
    }
    single<CurrencyRepo> {
        CurrencyRepoImpl(restApi = get())
    }
}

val domainDiModule = module {
    factory<GetCurrentCurrencyUseCase> { GetCurrentCurrencyUseCase(currencyRepo = get()) }
}

val appDiModule = module {
    viewModel<CurrencyViewModel> { CurrencyViewModel(getCurrency = get()) }
}