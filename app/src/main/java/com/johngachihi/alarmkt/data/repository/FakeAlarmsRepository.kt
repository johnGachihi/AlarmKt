package com.johngachihi.alarmkt.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.johngachihi.alarmkt.data.db.entities.Alarm

class FakeAlarmsRepository : AlarmsRepository {
    private val alarmsData: ArrayList<Alarm> = ArrayList()

    override val allAlarms: LiveData<List<Alarm>>
        get() = MutableLiveData<List<Alarm>>().apply {
            setValue(alarmsData)
        }

    override suspend fun addAlarm(alarm: Alarm) {
        alarmsData.add(alarm)
    }

    override suspend fun deleteAll() {
        alarmsData.clear()
    }

}
