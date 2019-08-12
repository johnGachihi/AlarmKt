package com.johngachihi.alarmkt.addeditalarms

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.johngachihi.alarmkt.MainCoroutineRule
import com.johngachihi.alarmkt.addeditalarm.AddEditAlarmViewModel
import com.johngachihi.alarmkt.data.db.entities.Alarm
import com.johngachihi.alarmkt.data.models.AlarmState
import com.johngachihi.alarmkt.data.models.AlarmTime
import com.johngachihi.alarmkt.data.repository.AlarmsRepository
import com.johngachihi.alarmkt.data.repository.FakeAlarmsRepository
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class AddEditAlarmViewModelTest {

    private lateinit var addEditAlarmViewModel: AddEditAlarmViewModel

    private lateinit var fakeRepository: AlarmsRepository

//     Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun initViewModel() {
        fakeRepository = FakeAlarmsRepository()

        addEditAlarmViewModel = AddEditAlarmViewModel(fakeRepository)
    }

    @Test @SmallTest
    fun addNewAlarmToRepository() {
        addEditAlarmViewModel.addAlarm(1, 2)

        val result = fakeRepository.allAlarms.value
        val alarm: Alarm? = result?.get(0)
        assertEquals(1, result?.size)
        assertEquals(1, result?.get(0)?.alarmTime?.hourOfDay)
        assertEquals(2, result?.get(0)?.alarmTime?.minute)
    }

    @Test @SmallTest
    fun retrieveAllAlarms_whenEmpty() = runBlocking {
        val result = addEditAlarmViewModel.allAlarms.value

        assertEquals(0, result?.size)
    }

    @Test @SmallTest
    fun retrieveAllAlarms_whenNotEmpty() = runBlocking {
        fakeRepository.addAlarm(Alarm(1, AlarmTime(1, 2), 1, AlarmState.OFF))
        val result = addEditAlarmViewModel.allAlarms.value

        assertEquals(1, result?.size)
        assertEquals(1, result?.get(0)?.id)
    }

}