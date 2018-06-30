package com.app.bissudroid.androidtutorials.outputs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.app.bissudroid.androidtutorials.R;

//To create an activity,you have to extend AppCompatActivity.
public class Activity_Main_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView binds the xml file to the java file.
        setContentView(R.layout.activity_main_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Simple Activity");
    }
}
