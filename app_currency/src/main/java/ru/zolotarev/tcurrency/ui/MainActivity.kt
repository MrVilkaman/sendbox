package ru.zolotarev.tcurrency.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.zolotarev.tcurrency.R
import ru.zolotarev.tcurrency.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val vm: CurrencyViewModel by viewModels()

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm.uiLiveData.observe(this, ::update)
    }

    private fun update(ui: UiModel) {
        val (usdCoast, eurusd, usdBuy, spred, usdSold) = ui


        binding.title1.text = "1 USD = $usdCoast RUB"

        binding.value1.text = "покупаю 1\$ за\t\t спред\t\t продаю 1\$ за\n" +
            "$usdBuy RUB\t\t\t${spred.format(2)}%\t\t\t$usdSold RUB"

        binding.eurusd.text = "EUR / USD = $eurusd"
    }
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)