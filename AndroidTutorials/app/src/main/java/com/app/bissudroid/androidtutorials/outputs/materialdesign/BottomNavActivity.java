package com.app.bissudroid.androidtutorials.outputs.materialdesign;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.app.bissudroid.androidtutorials.Constants;
import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.outputs.viewpager.FirstFragmentViewPager;
import com.app.bissudroid.androidtutorials.outputs.viewpager.SecondFragmentViewPager;
import com.app.bissudroid.androidtutorials.outputs.viewpager.ThirdFragmentViewPager;

public class BottomNavActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    FragmentManager fragmentManager;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomview);
        fragmentManager=getSupportFragmentManager();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        Toolbar toolbar=findViewById(R.id.mytoolbar);
        toolbar.setTitle("Bottom Navigation View");
        loadFirstFragment();



    }
    private void loadFirstFragment() {
        Handler handler = new Handler();
        handler.post(() -> {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frame, new FirstFragmentViewPager(), Constants.CAT_FRAG_TAG);
            fragmentTransaction.commit();

        });


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();



        switch (item.getItemId()){
            case R.id.category:
                fragmentTransaction.replace(R.id.frame, new FirstFragmentViewPager()).commit();
                break;
            case R.id.example:
                fragmentTransaction.replace(R.id.frame, new SecondFragmentViewPager(), Constants.EXAMPLE_FRAG_TAG).commit();
                break;
            case R.id.aboutus:
                fragmentTransaction.replace(R.id.frame, new ThirdFragmentViewPager(), Constants.EXAMPLE_FRAG_TAG).commit();
                break;

        }
        return true;
    }
}
