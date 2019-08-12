package com.johngachihi.alarmkt.addeditalarms

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.johngachihi.alarmkt.R
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class AddEditAlarmActivityTest {

    @Test
    fun addAlarmFromTimePickerFragment() {
        //Given

        //When
        onView(withId(R.id.addAlarmFab)).perform(click())

        //Then
        onView(withText("OK")).check(matches(isDisplayed()))
    }
}