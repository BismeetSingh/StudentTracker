package com.app.bissudroid.androidtutorials.outputs.examples;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.app.bissudroid.androidtutorials.R;

public class CustomDialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Button button = findViewById(R.id.clickbtn);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Custom Dialog");
        ImageButton imageButton = findViewById(R.id.click_this);
        imageButton.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomDialogActivity.this);
                LayoutInflater layoutInflater = getLayoutInflater();
                View view = layoutInflater.inflate(R.layout.custom_dialog, findViewById(R.id.dialoglayout));
                builder.setView(view);
                EditText editText = view.findViewById(R.id.edittext);

                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CustomDialogActivity.this, "text is " + editText.getText().toString(), Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CustomDialogActivity.this, "No clicked", Toast.LENGTH_SHORT).show();

                        dialog.dismiss();

                    }
                });
                builder.create().show();


            }
        });

    }
}
