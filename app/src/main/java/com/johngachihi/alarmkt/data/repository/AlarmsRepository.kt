package com.johngachihi.alarmkt.data.repository

import androidx.lifecycle.LiveData
import com.johngachihi.alarmkt.data.db.entities.Alarm

interface AlarmsRepository {

    val allAlarms: LiveData<List<Alarm>>

    suspend fun addAlarm(alarm: Alarm)

    suspend fun deleteAll()
}