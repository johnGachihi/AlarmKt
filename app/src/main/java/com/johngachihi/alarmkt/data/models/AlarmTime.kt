package com.johngachihi.alarmkt.data.models

import java.util.*

class AlarmTime(val hourOfDay: Int, val minute: Int) {

    val long: Long get() =
        with(Calendar.getInstance()) {
            set(Calendar.HOUR_OF_DAY, hourOfDay)
            set(Calendar.MINUTE, minute)
            this.timeInMillis
        }

    companion object {
        fun longToAlarmTime(long: Long) : AlarmTime {
            val cal = Calendar.getInstance()
            cal.timeInMillis = long

            return AlarmTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE))
        }
    }
}