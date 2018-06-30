package com.app.bissudroid.androidtutorials.outputs.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.app.bissudroid.androidtutorials.R;

public class TimeActivity  extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("TimePicker");
        TimePicker timePicker =findViewById(R.id.timepicker);
        TextView view=findViewById(R.id.timepickertxt);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timeview, int hourOfDay, int minute) {
                view.setText("Hour: "+hourOfDay+"\n"+"Minutes: "+minute);
            }
        });

    }
}
