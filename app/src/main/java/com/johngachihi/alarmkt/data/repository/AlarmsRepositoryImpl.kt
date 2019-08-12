package com.johngachihi.alarmkt.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.johngachihi.alarmkt.data.db.daos.AlarmDao
import com.johngachihi.alarmkt.data.db.entities.Alarm


class AlarmsRepositoryImpl constructor(private val alarmDao: AlarmDao) : AlarmsRepository {

    override val allAlarms: LiveData<List<Alarm>>
        get() = alarmDao.getAll()

    @WorkerThread
    override suspend fun deleteAll() {
        alarmDao.deleteAll()
    }

    @WorkerThread
    override suspend fun addAlarm(alarm: Alarm) {
        alarmDao.addAlarm(alarm)
    }

}