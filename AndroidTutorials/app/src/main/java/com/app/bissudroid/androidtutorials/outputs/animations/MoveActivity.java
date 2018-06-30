package com.app.bissudroid.androidtutorials.outputs.animations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.app.bissudroid.androidtutorials.Constants;
import com.app.bissudroid.androidtutorials.R;

public class MoveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainanimation);
        Toolbar toolbar = findViewById(R.id.toolbar);

        Button button = findViewById(R.id.btnanimation);
        int pos = getIntent().getIntExtra(Constants.POSITION_KEY, 0);
        switch (pos) {
            case 0:
                toolbar.setTitle("Move");
                break;
            case 1:
                toolbar.setTitle("Slide");
                ;
                break;
            case 2:
                toolbar.setTitle("Rotate");
                break;
            case 3:
                toolbar.setTitle("Fade in");
                break;
            case 4:
                toolbar.setTitle("Fade Out");
                break;
            case 5:
                toolbar.setTitle("Scale Up");
                break;
            case 6:
                toolbar.setTitle("Blink");
                break;
        }



        button.setOnClickListener(v -> {
            Animation animation = null;
            switch (pos) {
                case 0:

                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                    break;
                case 1:

                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);

                    break;
                case 2:

                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

                    break;
                case 3:

                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

                    break;
                case 4:

                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);

                    break;
                case 5:

                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaleup);

                    break;
                case 6:

                    animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
            }
            if (animation != null) button.startAnimation(animation);

        });
    }
}
