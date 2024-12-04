package net.propertyApp.utils

import net.propertyApp.domain.utils.DateUtilsImpl

val dateUtilsForUi = DateUtilsImpl()

fun Long.convertToDate(): String {
    return dateUtilsForUi.convertEpochSecondsToLocalReadableDateString(this)
}