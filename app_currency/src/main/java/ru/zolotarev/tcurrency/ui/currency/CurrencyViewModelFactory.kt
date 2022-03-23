package ru.zolotarev.tcurrency.ui.currency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.zolotarev.tcurrency.di.DIContainer
import ru.zolotarev.tcurrency.domain.GetCurrentCurrencyUseCase

class CurrencyViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CurrencyViewModel(
            GetCurrentCurrencyUseCase(DIContainer.retrofit)
        ) as T
    }
}