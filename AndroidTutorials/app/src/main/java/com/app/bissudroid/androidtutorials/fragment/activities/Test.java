package com.app.bissudroid.androidtutorials.fragment.activities;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.app.bissudroid.androidtutorials.R;

public class Test extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        ImageView imageView=findViewById(R.id.image);
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat=AnimatedVectorDrawableCompat.create(getApplicationContext(),R.drawable.animation);
        imageView.setImageDrawable(animatedVectorDrawableCompat);
        Animatable animatable=(Animatable)imageView.getDrawable();

        animatable.start();

    }
}
