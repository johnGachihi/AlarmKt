package com.johngachihi.alarmkt.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.johngachihi.alarmkt.data.db.entities.Alarm

@Dao
interface AlarmDao {

    @Insert
    suspend fun addAlarm(alarm: Alarm)

    @Query("DELETE FROM alarms")
    suspend fun deleteAll()

    @Query("SELECT * FROM alarms ORDER BY id ASC")
    fun getAll() : LiveData<List<Alarm>>
}