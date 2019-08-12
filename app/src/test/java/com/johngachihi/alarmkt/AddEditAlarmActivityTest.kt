package com.johngachihi.alarmkt

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.johngachihi.alarmkt.addeditalarm.AddEditAlarmActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddEditAlarmActivityTest {

    @Test @SmallTest
    fun clickAddAlarmButton_showDialog() {
        //GIVEN
        val scenario: ActivityScenario<AddEditAlarmActivity> =
            ActivityScenario.launch(AddEditAlarmActivity::class.java)

        //WHEN
        onView(withId(R.id.addAlarmFab)).perform(click())

        //THEN
        onView(withText("Ble ble")).check(matches(isDisplayed()))
//        onView(withInputType(InputType.TYPE_CLASS_DATETIME)).check(matches(isDisplayed()))
//        assertEquals(scenario.state, Lifecycle.State.PAUSED)
//        scenario.moveToState(Lifecycle.State.)
    }
}