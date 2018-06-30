package com.app.bissudroid.androidtutorials.outputs.materialdesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.app.bissudroid.androidtutorials.R;

public class CollapsingToolbarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Collapsing Toolbar Layout");


    }
}
