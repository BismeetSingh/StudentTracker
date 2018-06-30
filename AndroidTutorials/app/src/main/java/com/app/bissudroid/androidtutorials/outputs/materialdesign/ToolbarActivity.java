package com.app.bissudroid.androidtutorials.outputs.materialdesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;


import com.app.bissudroid.androidtutorials.R;

public class ToolbarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        EditText editText=findViewById(R.id.toolbartitle);
        Toolbar toolbar=findViewById(R.id.toolbar);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                toolbar.setTitle(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
