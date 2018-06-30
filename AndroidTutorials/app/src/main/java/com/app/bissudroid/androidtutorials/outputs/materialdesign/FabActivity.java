package com.app.bissudroid.androidtutorials.outputs.materialdesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


import com.app.bissudroid.androidtutorials.R;

public class FabActivity  extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Floating Action Button");
        FloatingActionButton floatingActionButton=findViewById(R.id.fabbtn);
        CoordinatorLayout coordinatorLayout=findViewById(R.id.coordlayout);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout,"Fab was clicked",Snackbar.LENGTH_SHORT).setAction("Undo",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(FabActivity.this, "Undo clicked", Toast.LENGTH_SHORT).show();

                            }
                        }).show();
            }
        });

    }
}
