package com.johngachihi.alarmkt.repositories

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.johngachihi.alarmkt.data.db.entities.Alarm
import com.johngachihi.alarmkt.data.models.AlarmState
import com.johngachihi.alarmkt.data.models.AlarmTime
import com.johngachihi.alarmkt.data.repository.FakeAlarmsRepository
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FakeAlarmsRepositoryTest {

    private lateinit var fakeAlarmsRepository: FakeAlarmsRepository

    @Before
    fun initAlarmsRepo() {
        fakeAlarmsRepository = FakeAlarmsRepository()
    }

    @Test
    fun addAlarm() = runBlocking {
        val alarm = Alarm(1, AlarmTime(1, 2), 1, AlarmState.ON)
        fakeAlarmsRepository.addAlarm(alarm = alarm)

        assertEquals(1, fakeAlarmsRepository.allAlarms.value?.size)
    }
}