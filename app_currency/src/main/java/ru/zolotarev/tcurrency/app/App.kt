package ru.zolotarev.tcurrency.app

import android.app.Application
import ru.zolotarev.tcurrency.di.setupKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        setupKoin()
    }
}