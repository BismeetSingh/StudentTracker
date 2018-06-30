package com.app.bissudroid.androidtutorials.outputs.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.app.bissudroid.androidtutorials.R;

public class ToggleButtonsImplementation extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Toggle");
        ToggleButton toggleButton = findViewById(R.id.togglebtn);

        toggleButton.setOnCheckedChangeListener(((buttonView, isChecked) ->
        {
            Toast.makeText(this, "Button " + isChecked, Toast.LENGTH_SHORT).show();
        }));
    }
}
