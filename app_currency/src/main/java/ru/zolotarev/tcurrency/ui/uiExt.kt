package ru.zolotarev.tcurrency.ui


fun Double.format(digits: Int) = "%.${digits}f".format(this)
