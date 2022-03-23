package ru.zolotarev.tcurrency.ui

import java.util.Locale


fun Double.format(digits: Int) = "%.${digits}f".format(Locale.ROOT,this)
