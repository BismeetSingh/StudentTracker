package com.app.bissudroid.androidtutorials.outputs.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.bissudroid.androidtutorials.R;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout userlayout,passwordlayout;
    EditText username,password;
    SharedPreferences sharedPreferences;
    Button button;
    Button logout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("SharedPreferences");
        userlayout=findViewById(R.id.userlayout);
        passwordlayout=findViewById(R.id.passwordlayout);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        button=findViewById(R.id.loginbtn);
        logout=findViewById(R.id.logoutbtn);
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();;
                String pass=password.getText().toString();
                if(!user.isEmpty() && !pass.isEmpty()){
                    String oldname=sharedPreferences.getString("name","");
                    String oldpwd=sharedPreferences.getString("password","");
                    if(user.equals(oldname) && pass.equals(oldpwd)){
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        sharedPreferences.edit().putBoolean("isloggedin",true).apply();
                        logout.setVisibility(View.VISIBLE);
                        username.setVisibility(View.INVISIBLE);
                        password.setVisibility(View.INVISIBLE);
                        button.setVisibility(View.INVISIBLE);
                        userlayout.setVisibility(View.GONE);
                        passwordlayout.setVisibility(View.GONE);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().clear().apply();
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sharedPreferences!=null && sharedPreferences.getBoolean("isloggedin",false)){
            logout.setVisibility(View.VISIBLE);
            button.setVisibility(View.INVISIBLE);
            username.setVisibility(View.INVISIBLE);
            password.setVisibility(View.INVISIBLE);
            userlayout.setVisibility(View.GONE);
            passwordlayout.setVisibility(View.GONE);
        }
    }
}
