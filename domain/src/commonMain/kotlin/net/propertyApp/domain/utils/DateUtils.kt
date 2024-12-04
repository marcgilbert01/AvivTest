package net.propertyApp.domain.utils

interface DateUtils {

    fun convertEpochSecondsToLocalReadableDateString(timeStamp: Long): String

}