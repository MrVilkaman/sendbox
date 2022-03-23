package ru.zolotarev.tcurrency.ui.currency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.zolotarev.tcurrency.domain.usecase.GetCurrentCurrencyUseCase


class CurrencyViewModel(
    private val getCurrency: GetCurrentCurrencyUseCase
) : ViewModel() {

    private val uiLiveDataMutable: MutableLiveData<UiModel> = MutableLiveData()
    private val isRefreshingMutable: MutableLiveData<Boolean> = MutableLiveData(false)

    val uiLiveData: LiveData<UiModel> get() = uiLiveDataMutable
    val isRefreshing: LiveData<Boolean> get() = isRefreshingMutable

    init {
        onLoadCurrency()
    }

    private fun onLoadCurrency() {
        viewModelScope.launch(Dispatchers.Main) {
            uiLiveDataMutable.value = getCurrency().toUiModel()
            isRefreshingMutable.value = false
        }
    }

    fun onRefresh() {
        isRefreshingMutable.value = true
        onLoadCurrency()
    }
}


