package com.app.bissudroid.androidtutorials.outputs.materialdesign;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.app.bissudroid.androidtutorials.R;

public class SharedElementDestinationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if(Build.VERSION.SDK_INT>=21){
            getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        }
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_transition_destination);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Shared Element Transitions");


    }
}
