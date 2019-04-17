package com.example.mathieu.pinthop;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathieu on 28/03/2016.
 */
public class CustomTimePickerDialog extends TimePickerDialog {

    public static int closed = 0;
    private final static int TIME_PICKER_INTERVAL = 15;
    private TimePicker timePicker;
    private final OnTimeSetListener callback;
    private static final String TAG = "myApp";
    private int buttontimepicker = 0;

    public CustomTimePickerDialog(Context context, int themeResId, OnTimeSetListener callBack,
                                  final int hourOfDay, final int minute, boolean is24HourView) {
        super(context, themeResId, callBack, hourOfDay, minute / TIME_PICKER_INTERVAL,
                is24HourView);
        this.callback = callBack;
        this.setTitle("Choisir un horaire");

        buttontimepicker = TabBaseDeDonnees.button_timepicker;

        if(buttontimepicker == 15 || buttontimepicker == 16) {
            this.setButton(BUTTON_NEUTRAL, "Inexistant", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (callback != null && timePicker != null) {
                        closed = 1;
                        timePicker.clearFocus();
                        callback.onTimeSet(timePicker, 11,
                                0 * TIME_PICKER_INTERVAL);
                    }
                }
            });
        }

        else
        {
            this.setButton(BUTTON_NEUTRAL, "Fermé", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (callback != null && timePicker != null) {
                        closed = 1;
                        timePicker.clearFocus();
                        callback.onTimeSet(timePicker, 11,
                                0 * TIME_PICKER_INTERVAL);
                    }
                }
            });
        }

        this.setButton(BUTTON_NEGATIVE, "Annuler", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        this.setButton(BUTTON_POSITIVE, "Appliquer", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (callback != null && timePicker != null) {
                    closed = 0;
                    timePicker.clearFocus();
                    callback.onTimeSet(timePicker, timePicker.getCurrentHour(),
                            timePicker.getCurrentMinute() * TIME_PICKER_INTERVAL);
                }
            }
        });
    };

    @Override
    protected void onStop() {
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {

            Class<?> classForid = Class.forName("com.android.internal.R$id");
            Field timePickerField = classForid.getField("timePicker");
            this.timePicker = (TimePicker) findViewById(timePickerField.getInt(null));
            Field field = classForid.getField("minute");

            NumberPicker mMinuteSpinner = (NumberPicker) timePicker.findViewById(field.getInt(null));
            mMinuteSpinner.setMinValue(0);
            mMinuteSpinner.setMaxValue((60 / TIME_PICKER_INTERVAL) - 1);
            List<String> displayedValues = new ArrayList<String>();

            for (int i = 0; i < 60; i += TIME_PICKER_INTERVAL)
            {
                displayedValues.add(String.format("%02d", i));
            }

            mMinuteSpinner.setDisplayedValues(displayedValues.toArray(new String[0]));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}