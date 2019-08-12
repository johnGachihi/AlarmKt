package com.johngachihi.alarmkt.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.johngachihi.alarmkt.data.models.AlarmState
import com.johngachihi.alarmkt.data.models.AlarmTime

@Entity(tableName = "alarms")
data class Alarm(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "alarm_time") val alarmTime: AlarmTime,
    @ColumnInfo(name = "alarm_tune") val tune: Int,
    val status: AlarmState
)