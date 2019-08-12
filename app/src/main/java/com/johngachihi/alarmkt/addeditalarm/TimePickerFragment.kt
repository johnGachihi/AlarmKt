package com.johngachihi.alarmkt.addeditalarm

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.johngachihi.alarmkt.R
import org.koin.android.viewmodel.ext.android.sharedViewModel
import java.util.*

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    private val viewModel by sharedViewModel<AddEditAlarmViewModel>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val cal = Calendar.getInstance()

        return TimePickerDialog(context, R.style.AppTheme_TimePickerDialog, this,
            cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),
            DateFormat.is24HourFormat(activity)
        )
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        viewModel.addAlarm(hourOfDay, minute)
    }


}