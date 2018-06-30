package com.app.bissudroid.androidtutorials.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.bissudroid.androidtutorials.R;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageView=findViewById(R.id.splashicon);
        TextView textView=findViewById(R.id.splashtext);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //imageView.startAnimation(imageanAnimation);
                AnimatedVectorDrawableCompat animatedVectorDrawableCompat=AnimatedVectorDrawableCompat.create(getApplicationContext(),R.drawable.animation);
                imageView.setImageDrawable(animatedVectorDrawableCompat);
                if (animatedVectorDrawableCompat != null) {
                    animatedVectorDrawableCompat.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
                        @Override
                        public void onAnimationEnd(Drawable drawable) {
                            super.onAnimationEnd(drawable);
                            try {
                                Thread.sleep(1000);
                                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                                finish();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
                Animatable animatable=(Animatable)imageView.getDrawable();

                animatable.start();


            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        new Handler().post(() -> {
            textView.startAnimation(animation);



        });




    }
}
