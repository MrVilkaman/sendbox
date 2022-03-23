package ru.zolotarev.tcurrency.ui.currency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.zolotarev.tcurrency.data.repoimpl.CurrencyRepoImpl
import ru.zolotarev.tcurrency.di.DIContainer
import ru.zolotarev.tcurrency.domain.usecase.GetCurrentCurrencyUseCase

class CurrencyViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CurrencyViewModel(
            GetCurrentCurrencyUseCase(CurrencyRepoImpl(DIContainer.retrofit))
        ) as T
    }
}