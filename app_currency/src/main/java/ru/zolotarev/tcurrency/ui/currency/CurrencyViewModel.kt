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

    private val _uiLiveData: MutableLiveData<UiModel> = MutableLiveData()
    val uiLiveData: LiveData<UiModel> get() = _uiLiveData

    init {

        viewModelScope.launch(Dispatchers.Main) {

            _uiLiveData.value = getCurrency().toUiModel()
        }
    }
}


