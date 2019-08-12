package com.johngachihi.alarmkt.addeditalarm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johngachihi.alarmkt.data.repository.AlarmsRepository
import com.johngachihi.alarmkt.data.db.entities.Alarm
import com.johngachihi.alarmkt.data.models.AlarmState
import com.johngachihi.alarmkt.data.models.AlarmTime
import kotlinx.coroutines.launch

class AddEditAlarmViewModel(val repository: AlarmsRepository) : ViewModel() {

    val allAlarms: LiveData<List<Alarm>> get() =
        repository.allAlarms

    fun addAlarm(hourOfDay: Int, minute: Int) = viewModelScope.launch {
        val alarm = Alarm(
            null,
            AlarmTime(hourOfDay, minute), 1, AlarmState.ON
        )

        repository.addAlarm(alarm)
    }
}