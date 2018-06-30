package com.app.bissudroid.androidtutorials.outputs.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.app.bissudroid.androidtutorials.R;

public class SwitchesImplementation extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        SwitchCompat switchCompat = findViewById(R.id.switches);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Switch");
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(SwitchesImplementation.this, "" + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
