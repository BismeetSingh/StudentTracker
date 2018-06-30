package com.app.bissudroid.androidtutorials.outputs.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.app.bissudroid.androidtutorials.R;

public class CheckBoxImplementation extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("CheckBox");
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.first:
                if (checked) Toast.makeText(this, "First checked", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "First unchecked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.second:
                if (checked) Toast.makeText(this, "Second checked", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "Second unchecked", Toast.LENGTH_SHORT).show();
        }
    }
}
