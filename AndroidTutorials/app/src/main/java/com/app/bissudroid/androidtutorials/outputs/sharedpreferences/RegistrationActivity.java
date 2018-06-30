package com.app.bissudroid.androidtutorials.outputs.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.bissudroid.androidtutorials.R;

public class RegistrationActivity extends AppCompatActivity {
    TextInputLayout userlayout, passwordlayout;
    EditText username, password;
    Button button;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        userlayout = findViewById(R.id.userlayout);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("SharedPreferences");
        passwordlayout = findViewById(R.id.passwordlayout);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button=findViewById(R.id.registerbtn);
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                    Toast.makeText(RegistrationActivity.this, "Registering", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();

                    editor.putString("name",username.getText().toString());
                    editor.putString("password",password.getText().toString());
                    editor.apply();
                    Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sharedPreferences!=null){
            if(sharedPreferences.getBoolean("isloggedin",false)){
                Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        }
    }
}
