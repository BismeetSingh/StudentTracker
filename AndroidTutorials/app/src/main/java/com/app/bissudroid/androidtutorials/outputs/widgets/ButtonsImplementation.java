package com.app.bissudroid.androidtutorials.outputs.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.app.bissudroid.androidtutorials.R;

public class ButtonsImplementation extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Button button = findViewById(R.id.clickbtn);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Buttons");
        button.setOnClickListener(v -> Toast.makeText(ButtonsImplementation.this, "Button was clicked", Toast.LENGTH_SHORT).show());
        ImageButton imageButton = findViewById(R.id.click_this);
        imageButton.setOnClickListener(v -> Toast.makeText(ButtonsImplementation.this, "ImageButton was clicked", Toast.LENGTH_SHORT).show());
    }
}
