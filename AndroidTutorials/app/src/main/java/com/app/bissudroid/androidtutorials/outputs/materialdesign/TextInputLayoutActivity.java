package com.app.bissudroid.androidtutorials.outputs.materialdesign;

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

public class TextInputLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("TextInputLayout");
        EditText username=findViewById(R.id.username);
        EditText password=findViewById(R.id.password);
        TextInputLayout userlayout=findViewById(R.id.userlayout);
        TextInputLayout passwordlayout=findViewById(R.id.passwordlayout);
        Button click=findViewById(R.id.clickbtn);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pwd=password.getText().toString();
                if(user.isEmpty()){
                    userlayout.setError("Please fill a username");
                }
                else {
                    userlayout.setError(null);
                }
                 if(pwd.isEmpty()){
                    passwordlayout.setError("Please fill a  password");
                }
                else {
                    passwordlayout.setError(null);
                 }
                if(!user.isEmpty() && !pwd.isEmpty()) {

                    Toast.makeText(TextInputLayoutActivity.this, "Click Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
