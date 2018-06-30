package com.app.bissudroid.androidtutorials.outputs.architecture_components;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.databinding.ActivityViewmodelBinding;
import com.app.bissudroid.androidtutorials.outputs.animations.MyViewModel;

public class ViewModelActivity extends AppCompatActivity {
    ActivityViewmodelBinding activityViewmodelBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityViewmodelBinding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel);
        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("ViewModels");
        activityViewmodelBinding.setModel(myViewModel);
        myViewModel.toastmsg.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(ViewModelActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
