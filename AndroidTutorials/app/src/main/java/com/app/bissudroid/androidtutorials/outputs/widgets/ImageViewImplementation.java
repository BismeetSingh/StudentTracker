package com.app.bissudroid.androidtutorials.outputs.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.bissudroid.androidtutorials.R;

public class ImageViewImplementation extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView imageView = findViewById(R.id.images);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("ImageViews");

        imageView.setOnClickListener(v -> Toast.makeText(ImageViewImplementation.this, "Image was clicked", Toast.LENGTH_SHORT).show());
    }
}
