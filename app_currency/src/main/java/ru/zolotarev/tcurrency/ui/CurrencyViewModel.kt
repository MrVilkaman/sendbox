package ru.zolotarev.tcurrency.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CurrencyViewModel : ViewModel() {

    private val _uiLiveData: MutableLiveData<UiModel> = MutableLiveData()
    val uiLiveData: LiveData<UiModel> get() = _uiLiveData

    init {

        viewModelScope.launch(Dispatchers.Main) {
            var index = 0

            while (true) {
                _uiLiveData.value = UiModel(

                    100.0 + index,
                    1.1,
                    130.0,
                    60.0,
                    110.0,
                )
                index++
                delay(1000)
            }
        }
    }
}


