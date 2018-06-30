package com.app.bissudroid.androidtutorials.outputs.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;

import com.app.bissudroid.androidtutorials.R;

import java.util.Calendar;

import timber.log.Timber;

public class DatePickerActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("DatePicker");
        DatePicker datePicker=findViewById(R.id.datepicker);
        TextView dateText=findViewById(R.id.datetext);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)
                , new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dateText.setText(String.format("Year=%d Month=%d day=%d", year, monthOfYear + 1, dayOfMonth));


                    }
                });


    }
}
