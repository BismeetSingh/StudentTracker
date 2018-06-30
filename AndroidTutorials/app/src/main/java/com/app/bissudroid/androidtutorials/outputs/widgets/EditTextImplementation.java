package com.app.bissudroid.androidtutorials.outputs.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.app.bissudroid.androidtutorials.R;

public class EditTextImplementation extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ediittext);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("EditText");
    }
}
