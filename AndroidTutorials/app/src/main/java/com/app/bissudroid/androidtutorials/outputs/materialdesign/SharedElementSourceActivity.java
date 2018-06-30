package com.app.bissudroid.androidtutorials.outputs.materialdesign;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.app.bissudroid.androidtutorials.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class SharedElementSourceActivity extends AppCompatActivity {
    private CircleImageView imgLogo, imgProfilePic;
    private TextView txtShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_transition_source);
        imgLogo = findViewById(R.id.imgAppLogo);
        imgProfilePic = findViewById(R.id.imgPic);
        txtShared = findViewById(R.id.txvSharedElement);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Shared Element Transitions");

    }


    public void sharedElementTransition(View view) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Pair[] pair = new Pair[3];
            pair[0] = new Pair<View, String>(imgLogo, "logo_shared");
            pair[1] = new Pair<View, String>(imgProfilePic, "pic_shared");
            pair[2] = new Pair<View, String>(txtShared, "name_shared");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SharedElementSourceActivity.this,
                    pair);
            Intent intent = new Intent(SharedElementSourceActivity.this, SharedElementDestinationActivity.class);
            startActivity(intent, options.toBundle());
        }
    }
}
