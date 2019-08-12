package com.johngachihi.alarmkt.data.db.converters

import androidx.room.TypeConverter
import com.johngachihi.alarmkt.data.models.AlarmState
import com.johngachihi.alarmkt.data.models.AlarmTime

class RoomConverters {

    @TypeConverter
    fun stringtoAlarmState(state: String?) : AlarmState? =
        state?.let { AlarmState.valueOf(it) }

    @TypeConverter
    fun alarmStateToString(state: AlarmState?) : String? =
        state?.let { state.name }


    @TypeConverter
    fun alarmTimeToLong(time: AlarmTime?) : Long? = time?.long

    @TypeConverter
    fun longToAlarmTime(long: Long?) : AlarmTime? = long?.let { AlarmTime.longToAlarmTime(it) }

}