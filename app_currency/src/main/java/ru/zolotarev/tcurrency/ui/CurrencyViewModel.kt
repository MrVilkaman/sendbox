package ru.zolotarev.tcurrency.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.zolotarev.tcurrency.domain.GetCurrentCurrencyUseCase


class CurrencyViewModel(
    private val getCurrency: GetCurrentCurrencyUseCase
) : ViewModel() {

    private val _uiLiveData: MutableLiveData<UiModel> = MutableLiveData()
    val uiLiveData: LiveData<UiModel> get() = _uiLiveData

    init {

        viewModelScope.launch(Dispatchers.Main) {

            val first = getCurrency()

            val spred = (first.sell - first.buy) / first.sell * 100
            val usdCoast = (first.sell + first.buy) / 2
            _uiLiveData.value = UiModel(

                usdCoast,
                1.1,
                first.sell,
                spred,
                first.buy,
            )
        }
    }
}


