package com.example.notificationapplication;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;


public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private AlarmManager mAlarmManager;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mAlarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getContext(), this, hour, minute, DateFormat.is24HourFormat(getContext()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);

        Intent intent = new Intent(getContext(), AlarmManagerActivity.class);
        PendingIntent operation = PendingIntent.getActivity(getContext(), 0, intent, 0);
        mAlarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), operation);
    }
}
