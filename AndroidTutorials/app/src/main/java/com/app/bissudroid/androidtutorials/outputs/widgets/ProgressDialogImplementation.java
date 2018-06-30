package com.app.bissudroid.androidtutorials.outputs.widgets;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.app.bissudroid.androidtutorials.R;

public class ProgressDialogImplementation extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Progress Dialog");
        Button btn = findViewById(R.id.dialog);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//TODO fix colors
                ProgressDialog progressDialog = ProgressDialog.show(ProgressDialogImplementation.this, "Example", "Tap Screen to Dismiss", true);
                progressDialog.setCanceledOnTouchOutside(true);
                progressDialog.show();
            }
        });
    }
}
