package com.app.bissudroid.androidtutorials.activity;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.app.bissudroid.androidtutorials.Constants;
import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.databinding.ActivityMainBinding;
import com.app.bissudroid.androidtutorials.fragment.AboutUsFragment;
import com.app.bissudroid.androidtutorials.fragment.CategoryFragment;
import com.app.bissudroid.androidtutorials.fragment.ExamplesFragment;
import com.app.bissudroid.androidtutorials.viewmodels.MainActivityViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

import static com.app.bissudroid.androidtutorials.Constants.APP_PNAME;
import static com.app.bissudroid.androidtutorials.Constants.APP_TITLE;
import static com.app.bissudroid.androidtutorials.Constants.DAYS_UNTIL_PROMPT;
import static com.app.bissudroid.androidtutorials.Constants.LAUNCHES_UNTIL_PROMPT;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener
        , BottomNavigationView.OnNavigationItemSelectedListener {
    @Inject
    Context context;
    ActivityMainBinding activityMainBinding;
    MainActivityViewModel activityViewModel;
    FragmentManager fragmentManager;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        }
        AndroidInjection.inject(this);
        checkRating();
        super.onCreate(savedInstanceState);
        activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.bottomview.setOnNavigationItemSelectedListener(this);
        activityMainBinding.mytoolbar.toolbar.setTitle("Categories");
        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null)
            loadCategoryFragment();


    }

    private void checkRating() {
        SharedPreferences prefs = getSharedPreferences("apprater", 0);
        if (prefs.getBoolean("dontshowagain", false)) {
            return;
        }

        SharedPreferences.Editor editor = prefs.edit();

        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        // Wait at least n days before opening
        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch +
                    (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                showRateDialog(editor);
            }
        }

        editor.apply();

    }

    private void showRateDialog(SharedPreferences.Editor editor) {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Rate " + APP_TITLE);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dialog_rateus, findViewById(R.id.alertrate));
        Button rateus = view.findViewById(R.id.rateus);
        Button ratelater = view.findViewById(R.id.ratelater);
        Button nothnks = view.findViewById(R.id.nothanks);
        rateus.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME)));
            dialog.dismiss();
        });
        nothnks.setOnClickListener(v -> dialog.dismiss());
        ratelater.setOnClickListener(v -> {
            if (editor != null) {
                editor.putBoolean("dontshowagain", true);
                editor.commit();
//            }
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }


    private void loadCategoryFragment() {
        Handler handler = new Handler();
        handler.post(() -> {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frame, CategoryFragment.getInstance(), Constants.CAT_FRAG_TAG);
            fragmentTransaction.commit();

        });


    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if (fragmentManager != null) {
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        }
        switch (item.getItemId()) {
            case R.id.category:
                fragmentTransaction.replace(R.id.frame, CategoryFragment.getInstance()).commit();
                break;
            case R.id.example:
                fragmentTransaction.replace(R.id.frame, ExamplesFragment.getInstance(), Constants.EXAMPLE_FRAG_TAG).commit();
                break;
            case R.id.aboutus:
                fragmentTransaction.replace(R.id.frame, AboutUsFragment.getInstance(), Constants.ABOUT_US_TAG).commit();

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.findFragmentByTag(Constants.EXAMPLE_FRAG_TAG) != null
                && fragmentManager.getBackStackEntryCount() == 0
                ||
                fragmentManager.findFragmentByTag(Constants.ABOUT_US_TAG) != null
                        && fragmentManager.getBackStackEntryCount() == 0) {
            fragmentManager.popBackStack();
            fragmentManager.beginTransaction().replace(R.id.frame, CategoryFragment.getInstance()).commit();

        } else
            super.onBackPressed();


    }


}
