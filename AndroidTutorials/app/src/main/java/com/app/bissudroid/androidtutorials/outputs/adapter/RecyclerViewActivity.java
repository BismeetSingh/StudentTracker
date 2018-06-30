package com.app.bissudroid.androidtutorials.outputs.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.models.Users;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Recycler View");
        RecyclerView recyclerView=findViewById(R.id.rview);
        List<Users> users=Users.getUsers();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        CustomRecyclerViewAdapter customRecyclerViewAdapter=new CustomRecyclerViewAdapter(getApplicationContext());
        recyclerView.setAdapter(customRecyclerViewAdapter);
        customRecyclerViewAdapter.updateData(users);
    }
}
