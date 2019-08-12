package com.johngachihi.alarmkt

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.johngachihi.alarmkt.addeditalarm.AddEditAlarmActivity
import com.johngachihi.alarmkt.data.repository.AlarmsRepository
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(AndroidJUnit4::class)
class AddEditAlarmActivityInstrumentedTest : KoinTest {

    private val alarmsRepository: AlarmsRepository by inject()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun clickAddAlarmButton_showDialog() {
        //GIVEN
        val scenario: ActivityScenario<AddEditAlarmActivity> =
            ActivityScenario.launch(AddEditAlarmActivity::class.java)

        //WHEN
        onView(withId(R.id.addAlarmFab)).perform(click())

        //THEN
        onView(withText("OK")).check(matches(isDisplayed()))
        onView(withText("CANCEL")).check(matches(isDisplayed()))
    }

    @Test
    fun addAlarm() {
        //GIVEN
        val scenario = ActivityScenario.launch(AddEditAlarmActivity::class.java)

        //WHEN
        onView(withId(R.id.addAlarmFab)).perform(click())
        onView(withText("OK")).perform(click())

        //THEN
        val result = alarmsRepository.allAlarms.value
        assertEquals(1, result?.size)

    }
}